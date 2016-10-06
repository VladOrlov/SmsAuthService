package com.digi.entity.exception;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class NotValidForConfirmation extends RuntimeException {
	public NotValidForConfirmation (String ph) {
		super("The number "+ph+" is not a valid phone number for confirmation.");
	}
}
