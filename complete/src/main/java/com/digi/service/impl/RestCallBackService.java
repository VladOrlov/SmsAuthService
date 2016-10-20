package com.digi.service.impl;

import com.digi.entity.db.CallBackProperties;
import com.digi.entity.db.PhoneAuthLog;
import com.digi.entity.response.CallBackResponse;
import com.digi.service.CallBackService;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.URI;

import static java.util.Objects.nonNull;

@Service
@Slf4j
@Getter
@Accessors(fluent = true)
public class RestCallBackService implements CallBackService {

	@Autowired
	private RestTemplate rest;

	public URI getUri (String uri) {
		return URI.create(uri);
	}

	@Override
	public boolean doCallBack (PhoneAuthLog account, boolean success) {
		if (nonNull(account.getCallBack())) {
			try {
				send(account.getCallBack(), new CallBackResponse(account, success));
				return true;
			} catch (IllegalArgumentException | HttpClientErrorException ex) {
				log.error(ex.getMessage(), ex);
			}
		}
		return false;
	}

	protected void send (CallBackProperties properties, CallBackResponse callBackResult) {
		URI sendUri = getUri(properties.getCallBackUri());
		switch (properties.toHttpMethod()) {
			case POST:
				post(sendUri, callBackResult);
				break;
			case GET:
				get(sendUri, callBackResult);
				break;
			default:
				throw new NotImplementedException();
		}
	}

	protected void post (URI uri, CallBackResponse callBackResult) {
		rest.postForLocation(uri, callBackResult);
	}

	protected void get (URI uri, CallBackResponse callBackResult) {
		URI targetUrl = UriComponentsBuilder.fromUri(uri)
				.queryParams(callBackResult.toParams())
				.build()
				.toUri();
		rest.getForObject(targetUrl, String.class);
	}
}
