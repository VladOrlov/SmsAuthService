package com.digi.mvc;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by tymoshenkol on 07-Oct-16.
 */

public class TwilioSendTest extends MvcTest {

	@Test
	public void testSendAdminSms () throws Exception {

		this.mockMvc.perform(get("/sms/admin"))
				.andDo(print())
				.andExpect(status().isOk())

				//.andExpect(jsonPath("$.errorCode").value(IsNull.nullValue()))

				.andExpect(jsonPath("$.messageID").value(IsNull.notNullValue()))
				.andExpect(jsonPath("$.messageID").isString())
				.andExpect(jsonPath("$.messageID").isNotEmpty())

				.andExpect(jsonPath("$.messageStatus").value(IsNull.notNullValue()))
				.andExpect(jsonPath("$.messageStatus").isString())
				.andExpect(jsonPath("$.messageStatus").isNotEmpty());
	}

}
