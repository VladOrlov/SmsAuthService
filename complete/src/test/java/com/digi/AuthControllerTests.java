/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.digi;

import com.digi.entity.request.AccountToConfirm;
import com.digi.entity.request.AccountToVerify;
import com.digi.help.MockMvcTest;
import com.digi.util.JsonUtil;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AuthControllerTests extends MockMvcTest {


	@Test
	public void testNotValidForConfirmation () throws Exception {
		AccountToConfirm account = new AccountToConfirm();
		account.setPhone("123456");
		account.setCode("test");

		this.mockMvc.perform(
				post("/account/Confirm")
						.content(JsonUtil.asJsonString(account))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.error").value("NotValidAccountForConfirmation"))
				.andExpect(jsonPath("$.success").value(0));
	}

	@Test
	public void testAuthAndConfirm () throws Exception {
		AccountToVerify account = new AccountToVerify("14053264519");

		this.mockMvc.perform(
				post("/account/Authorise")
						.content(JsonUtil.asJsonString(account))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		this.mockMvc.perform(
				post("/account/Confirm")
						.content(JsonUtil.asJsonString(account))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}


}
