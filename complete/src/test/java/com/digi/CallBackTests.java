package com.digi;

import com.digi.entity.db.PhoneAuthLog;
import com.digi.help.MockMvcTest;
import com.digi.service.AuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by tymoshenkol on 13-Oct-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CallBackTests  {

	@Autowired
	protected AuthService authS;


	@Test
	public void testNotValidForConfirmation () {
		PhoneAuthLog acc = new PhoneAuthLog();
		acc.setCallBackUri("-");
		acc.setCode("dfbdkfb");
		acc.setSmsId("sdvsdvsdv");
		acc.setPhone("ssdvsdv");

		authS.doCallBack(acc, true);
	}
}
