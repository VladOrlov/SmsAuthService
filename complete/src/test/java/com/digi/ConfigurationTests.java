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

import com.digi.config.RandomKeyConfig;
import com.digi.config.TwilioCredentials;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ConfigurationTests {

	@Autowired
	private RandomKeyConfig randKeyCfg;
	@Autowired
	private TwilioCredentials twilio;


	@Test
	public void testRandomKeyConfig () throws Exception {
		log.debug("configuration: {}", randKeyCfg);
		assertThat(randKeyCfg.getSize()).isGreaterThan(2);
		assertThat(randKeyCfg.getPartitionSize()).isGreaterThan(0);
		assertThat(randKeyCfg.getDelimiter()).isNotEmpty();
		assertThat(randKeyCfg.getWithLetters()).isIn(true, false);
		assertThat(randKeyCfg.getPartitionSize()).isLessThan(randKeyCfg.getSize());
	}

	@Test
	public void testTwilioCredentials () throws Exception {
		log.debug("twilio: {}", twilio);
		assertThat(twilio.getAccountSid()).isNotEmpty();
		assertThat(twilio.getAuthToken()).isNotEmpty();
		assertThat(twilio.getPhoneNumber()).isNotEmpty();
	}

}
