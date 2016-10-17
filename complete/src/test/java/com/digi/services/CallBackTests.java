package com.digi.services;

import com.digi.entity.db.PhoneAuthLog;
import com.digi.help.AppSpringBootTestNG;
import com.digi.service.impl.RestPostCallBackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.testng.annotations.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tymoshenkol on 13-Oct-16.
 */
@Slf4j
public class CallBackTests extends AppSpringBootTestNG {

	@Autowired
	protected RestPostCallBackService callBack;

	@Test
	public void testCallBackService () {
		assertThat(callBack).isNotNull();
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testNotValidUrl () {
		callBack.getUri("http://");
	}

	@Test
	public void testValidUrl () {
		URI uri = callBack.getUri("https://www.google.com.ua/#q=test");
		assertThat(uri).isNotNull();
	}


	@Test(expectedExceptions = HttpClientErrorException.class, expectedExceptionsMessageRegExp = "405 Method Not Allowed")
	public void testValidUrlNotAllowedMethod () {
		PhoneAuthLog acc = new PhoneAuthLog();
		acc.setCallBackUri("https://www.google.com.ua/#q=test");
		log.debug("callBack: {}", callBack);
		assertThat(callBack.doCallBack(acc, true)).isFalse();
	}
}
