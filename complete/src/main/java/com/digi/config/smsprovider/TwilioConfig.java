package com.digi.config.smsprovider;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.twilio.notifications")
@SuppressWarnings("UnusedDeclaration")
public class TwilioConfig {
}