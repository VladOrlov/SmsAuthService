package com.digi.service.impl;

import com.digi.entity.db.PhoneAuthLog;
import com.digi.entity.response.CallBackResponse;
import com.digi.service.CallBackService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import java.net.URI;

@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@Slf4j
@Getter
@Accessors(fluent = true)
public class RestCallBackService implements CallBackService {

	private final RestTemplate rest;

	public URI getUri (String uri) {
		return URI.create(uri);
	}

	@Override
	public boolean doCallBack (PhoneAuthLog account, boolean success) {
		throw new NotImplementedException();
	}

	protected void post (URI uri, CallBackResponse response) {
		rest.postForLocation(uri, response);
	}

	protected void get (URI uri, CallBackResponse response) {
		throw new NotImplementedException();
	}

}
