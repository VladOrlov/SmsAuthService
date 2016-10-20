package com.digi.config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tymoshenkol on 20-Oct-16.
 */
@Configuration
public class BeanConfig {

	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}

}
