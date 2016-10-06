package com.digi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Configuration
@ConfigurationProperties(prefix = "app.admin")
@Data
public class Administrator {
	private String name;
	private String phoneNumber;
}
