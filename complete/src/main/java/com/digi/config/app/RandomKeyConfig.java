package com.digi.config.app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.random")
@Data
public class RandomKeyConfig {
	private Integer size;
	private Integer partitionSize;
	private String delimiter;
	private Boolean withLetters;
}