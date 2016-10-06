package com.digi.entity.exception;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class AlreadyConfirmed extends RuntimeException {
	public AlreadyConfirmed (String ph) {
		super("The number "+ph+" is already confirm authorization.");
	}
}
