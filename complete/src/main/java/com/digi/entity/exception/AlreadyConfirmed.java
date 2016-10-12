package com.digi.entity.exception;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class AlreadyConfirmed extends RuntimeException {
	public AlreadyConfirmed (String ph) {
		super(String.format("The number %1$s is already confirm authorization.", ph));
	}
}
