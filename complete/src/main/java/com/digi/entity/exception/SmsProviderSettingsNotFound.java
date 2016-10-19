package com.digi.entity.exception;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class SmsProviderSettingsNotFound extends RuntimeException {
	public SmsProviderSettingsNotFound () {
		super("There is not enough data to process.");
	}
}
