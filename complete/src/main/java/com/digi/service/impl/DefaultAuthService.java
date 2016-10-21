package com.digi.service.impl;

import com.digi.config.app.TextsConfig;
import com.digi.entity.db.PhoneAuthLog;
import com.digi.entity.enums.AuthStatus;
import com.digi.entity.exception.AlreadyAuthorized;
import com.digi.entity.exception.AlreadyConfirmed;
import com.digi.entity.exception.NotValidAccountForConfirmation;
import com.digi.entity.exception.NotValidConfirmationCode;
import com.digi.entity.request.AccountToConfirm;
import com.digi.entity.request.AccountToVerify;
import com.digi.entity.request.AccountToVerifyExt;
import com.digi.entity.request.SmsTemplate;
import com.digi.entity.response.MessageResponse;
import com.digi.entity.response.SuccessResponse;
import com.digi.repository.PhoneAuthLogRepository;
import com.digi.service.AuthService;
import com.digi.service.CallBackService;
import com.digi.service.ProviderFactory;
import com.digi.service.RandomService;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@Getter
@Accessors(fluent = true)
@Slf4j
public class DefaultAuthService implements AuthService {
	@Autowired
	private ProviderFactory smsProvider;
	@Autowired
	private RandomService randService;
	@Autowired
	private PhoneAuthLogRepository rLogs;
	@Autowired
	private TextsConfig txt;
	@Autowired
	private CallBackService callBack;

	public SuccessResponse authorise (AccountToVerifyExt account) {

		PhoneAuthLog existed = getFromLog(account);

		if (nonNull(existed)) {
			throw new AlreadyAuthorized(account.getPhone(), existed.getAuthStatus(), existed.getInitDate());
		}

		String secureCode = randService().generateCode();
		existed = new PhoneAuthLog(account, Calendar.getInstance(), secureCode, AuthStatus.Wait);

		String message = compileMessageText(account.getTemplate(), secureCode);

		MessageResponse m = smsProvider.get().sendMessage(account.getPhone(), message);

		existed.setSmsId(m.getMessageID());

		if (!m.isMessageQueued()) {
			existed.setAuthStatus(AuthStatus.SmsNotDelivered);
			return new SuccessResponse(existed, false);
		}

		save(existed);
		return new SuccessResponse(existed);
	}


	public PhoneAuthLog confirm (AccountToConfirm account) {

		PhoneAuthLog existed = getFromLog(account);

		if (isNull(existed)) {
			throw new NotValidAccountForConfirmation(account.getPhone());
		}

		if (existed.getAuthStatus().equals(AuthStatus.Confirmed)) {
			throw new AlreadyConfirmed(account.getPhone());
		}

		existed.validateCallBack(account);

		if (!existed.getCode().contentEquals(account.clearConfirmationCode())) {
			callBack.doCallBack(existed, false);
			throw new NotValidConfirmationCode(account.getPhone());
		}

		existed.setAuthStatus(AuthStatus.Confirmed);
		existed.setConfirmDate(Calendar.getInstance().getTime());
		save(existed);
		callBack.doCallBack(existed, true);
		return existed;
	}

	public PhoneAuthLog getFromLog (AccountToVerify account) {
		return rLogs().findByPhone(account.getPhone());
	}

	public String compileMessageText (SmsTemplate templ, String secureCode) {
		if (isNull(templ) || isNull(templ.getVerificationText()) || templ.getVerificationText().isEmpty()) {
			templ = (SmsTemplate) txt();
		}
		return templ.customVerificationText(randService().customizeCode(secureCode));
	}

	public void save (PhoneAuthLog logAcc) {
		rLogs().save(logAcc);
		log.debug("PhoneAuthLog/afterSave: {}", logAcc);
	}
}
