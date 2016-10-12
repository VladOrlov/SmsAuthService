package com.digi.service;

import com.digi.config.TextsConfig;
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
import com.digi.repository.PhoneAuthLogRepository;
import com.twilio.rest.api.v2010.account.Message;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.Date;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@Slf4j
@Getter  @Accessors(fluent=true)

public class AuthService {

	private final SmsService smsService;
	private final RandomService randService;
	private final PhoneAuthLogRepository rLogs;
	private final TextsConfig txt;

	public PhoneAuthLog authorise (AccountToVerifyExt account) {

		PhoneAuthLog existed = getFromLog(account);

		if (existed != null) {
			throw new AlreadyAuthorized(account.getPhone(), existed.getAuthStatus(), existed.getInitDate());
		}

		String secureCode = randService().generateCode();
		existed = new PhoneAuthLog(account.getPhone(), new Date(), secureCode, AuthStatus.Wait);

		String message = compileMessageText(account.getTemplate(), secureCode);

		Message m = smsService().sendMessage(account.getPhone(), message);

		existed.setSmsId(m.getSid());
		save(existed);

		return existed;
	}

	public PhoneAuthLog confirm (AccountToConfirm account) {

		PhoneAuthLog existed = getFromLog(account);

		if (existed == null) {
			throw new NotValidAccountForConfirmation(account.getPhone());
		}

		if (existed.getAuthStatus().equals(AuthStatus.Confirmed)) {
			throw new AlreadyConfirmed(account.getPhone());
		}

		if(!existed.getCode().contentEquals(account.clearConfirmationCode())){
			throw new NotValidConfirmationCode(account.getPhone());
		}

		existed.setAuthStatus(AuthStatus.Confirmed);
		existed.setConfirmDate(new Date());

		save(existed);
		return existed;
	}

	private PhoneAuthLog getFromLog(AccountToVerify account){
		return rLogs().findByPhone(account.getPhone());
	}

	private String compileMessageText(SmsTemplate templ, String secureCode){
		if(templ==null || templ.getVerificationText()==null || templ.getVerificationText().isEmpty()){
			templ = (SmsTemplate) txt();
		}
		return templ.customVerificationText(randService().customizeCode(secureCode));
	}

	private void save(PhoneAuthLog logAcc){
		rLogs().save(logAcc);
		log.debug("PhoneAuthLog/afterSave: {}", logAcc);
	}
}
