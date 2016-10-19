package com.digi.config.smsprovider;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

import static java.util.Objects.nonNull;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Configuration
@ConfigurationProperties
@PropertySource( value = "classpath:clickatell.properties")
public class ClickatellCredentials extends ProviderCredentials {
}
