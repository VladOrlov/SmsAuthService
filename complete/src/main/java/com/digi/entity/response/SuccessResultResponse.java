package com.digi.entity.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
@Data
public class SuccessResultResponse implements Serializable {
	private int success;
}
