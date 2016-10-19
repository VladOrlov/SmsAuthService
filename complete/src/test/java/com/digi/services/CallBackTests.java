package com.digi.services;

import com.digi.entity.db.CallBackProperties;
import com.digi.entity.db.PhoneAuthLog;
import com.digi.help.AppSpringBootTestNG;
import com.digi.service.impl.RestCallBackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tymoshenkol on 13-Oct-16.
 */
@Slf4j
public class CallBackTests extends AppSpringBootTestNG {

	@Autowired
	protected RestCallBackService callBack;

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


	@Test
	public void testValidUrlNotAllowedMethod () {
		PhoneAuthLog acc = new PhoneAuthLog();
		acc.setCallBack(new CallBackProperties(
				"https://www.google.com.ua/#q=test",
				"POST"
		));
		assertThat(callBack.doCallBack(acc, true)).isFalse();
	}
}
