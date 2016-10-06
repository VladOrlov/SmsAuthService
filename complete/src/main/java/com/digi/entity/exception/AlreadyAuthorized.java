package com.digi.entity.exception;

import com.digi.entity.enums.AuthStatus;
import com.digi.util.DateUtil;

import java.util.Date;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
public class AlreadyAuthorized extends RuntimeException {
	public AlreadyAuthorized (String ph, AuthStatus status, Date when) {
		super(String.format(
				"The number %1$s has already authorized (%2$s) / Status: %3$s",
				ph,DateUtil.ddMMyyyy(when),status.name() ));
	}
}
