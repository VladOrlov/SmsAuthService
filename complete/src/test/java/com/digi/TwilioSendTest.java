package com.digi;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by tymoshenkol on 07-Oct-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TwilioSendTest {
	@Autowired
	private MockMvc mockMvc;

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
