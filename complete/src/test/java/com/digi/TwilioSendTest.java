package com.digi;

import com.digi.help.MockMvcTest;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by tymoshenkol on 07-Oct-16.
 */

public class TwilioSendTest extends MockMvcTest {

	@Test
	public void testSendAdminSms () throws Exception {

		this.mockMvc.perform(get("/sms/admin"))
				.andDo(print())
				.andExpect(status().isOk())

				.andExpect(jsonPath("$.errorCode").value(IsNull.nullValue()))

				.andExpect(jsonPath("$.sid").value(IsNull.notNullValue()))
				.andExpect(jsonPath("$.sid").isString())
				.andExpect(jsonPath("$.sid").isNotEmpty())

				.andExpect(jsonPath("$.status").value("QUEUED"))
				.andExpect(jsonPath("$.numMedia").value("0"))
				.andExpect(jsonPath("$.numSegments").value("1"));
	}

}
