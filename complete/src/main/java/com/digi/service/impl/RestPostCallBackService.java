package com.digi.service.impl;

import com.digi.entity.db.PhoneAuthLog;
import com.digi.entity.response.CallBackResponse;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@Getter
@Accessors(fluent = true)
public class RestPostCallBackService extends RestCallBackService {


	public RestPostCallBackService (RestTemplate rest) {
		super(rest);
	}

	@Override
	public boolean doCallBack (PhoneAuthLog account, boolean success) {
		if (account.getCallBackUri() != null && !account.getCallBackUri().isEmpty()) {
			try {
				post(getUri(account.getCallBackUri()), new CallBackResponse(account, success));
				return true;
			} catch (IllegalArgumentException | HttpClientErrorException ex) {
				log.error(ex.getMessage(), ex);
			}
		}
		return false;
	}
}
