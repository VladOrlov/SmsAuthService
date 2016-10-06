package com.digi.config;

import lombok.AllArgsConstructor;
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