package com.digi.entity.exception;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class NotValidConfirmationCode extends RuntimeException {
	public NotValidConfirmationCode (String ph) {
		super(String.format("The verification code for %1$s is not a valid.", ph));
	}
}
