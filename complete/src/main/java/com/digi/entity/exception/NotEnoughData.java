package com.digi.entity.exception;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class NotEnoughData extends RuntimeException {
	public NotEnoughData () {
		super("There is not enough data to process.");
	}
}
