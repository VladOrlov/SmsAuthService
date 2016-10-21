package com.digi.service;

import com.digi.entity.db.PhoneAuthLog;
import com.digi.entity.request.AccountToConfirm;
import com.digi.entity.request.AccountToVerify;
import com.digi.entity.request.AccountToVerifyExt;
import com.digi.entity.request.SmsTemplate;
import com.digi.entity.response.SuccessResponse;


public interface AuthService {

	SuccessResponse authorise (AccountToVerifyExt account);

	PhoneAuthLog confirm (AccountToConfirm account);

}
