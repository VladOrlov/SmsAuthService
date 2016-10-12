package com.digi.entity.exception;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class NotValidAccountForConfirmation extends RuntimeException {
	public NotValidAccountForConfirmation (String ph) {
		super(String.format("The number %1$s is not a valid phone number for confirmation.", ph));
	}
}
