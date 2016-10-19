package com.digi.config.smsprovider;

import lombok.Data;

import java.io.Serializable;

import static java.util.Objects.nonNull;

/**
 * Created by tymoshenkol on 19-Oct-16.
 */
@Data
public class ProviderCredentials implements Serializable {
	private String authToken;

	public boolean isValid () {
		return nonNull(getAuthToken());
	}
}
