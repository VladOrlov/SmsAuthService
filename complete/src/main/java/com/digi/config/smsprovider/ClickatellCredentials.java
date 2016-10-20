package com.digi.config.smsprovider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Configuration
@ConfigurationProperties
@PropertySource( value = "classpath:application-sms-clickatell.properties")
public class ClickatellCredentials extends ProviderCredentials {
}
