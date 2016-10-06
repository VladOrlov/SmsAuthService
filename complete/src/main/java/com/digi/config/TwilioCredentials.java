package com.digi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Configuration
@ConfigurationProperties(prefix = "app.twilio")
@Data
public class TwilioCredentials implements Serializable {
	private String accountSid;
	private String authToken;
	private String phoneNumber;
}
