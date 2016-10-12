package com.digi.config;

import com.digi.entity.request.SmsTemplate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Configuration
@ConfigurationProperties(prefix = "app.text")
@NoArgsConstructor
public class TextsConfig extends SmsTemplate {

}
