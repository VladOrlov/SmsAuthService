package com.digi.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static java.util.Objects.nonNull;

/**
 * Created by tymoshenkol on 05-Oct-16.
 */
@Getter
@RequiredArgsConstructor
public enum AuthStatus {
	Wait(0), Confirmed(1), SmsNotDelivered(2);

	@NonNull
	private int id;

	public static AuthStatus valueOf (Integer ID) {
		if (nonNull(ID)) {
			try {
				return Arrays.stream(values()).filter(x -> x.id == ID).findFirst().get();
			} catch (NoSuchElementException e) {
				return Wait;
			}
		}
		return null;
	}
}
