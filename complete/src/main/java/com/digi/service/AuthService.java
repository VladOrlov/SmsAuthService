package com.digi.service;

import com.digi.entity.db.PhoneAuthLog;
import com.digi.entity.request.AccountToConfirm;
import com.digi.entity.request.AccountToVerify;
import com.digi.entity.request.AccountToVerifyExt;
import com.digi.entity.request.SmsTemplate;


public interface AuthService {

	PhoneAuthLog authorise (AccountToVerifyExt account);

	PhoneAuthLog confirm (AccountToConfirm account);

	PhoneAuthLog getFromLog (AccountToVerify account);

	String compileMessageText (SmsTemplate templ, String secureCode);

	void save (PhoneAuthLog logAcc);
}
