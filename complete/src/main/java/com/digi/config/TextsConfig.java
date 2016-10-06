package com.digi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Configuration
@ConfigurationProperties(prefix = "app.text")
@Data
public class TextsConfig implements Serializable {
	private String applicationName;
	private String verification;


	public String customVerificationText(String authCode){
		return customText(verification).replaceAll("#authCode#", authCode);
	}

	private String customText(String txt){
		return txt.replaceAll("#applicationName#", applicationName);
	}
}
