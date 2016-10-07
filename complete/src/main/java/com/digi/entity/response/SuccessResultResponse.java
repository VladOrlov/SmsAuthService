package com.digi.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
@Data
public class SuccessResultResponse implements Serializable {
	@ApiModelProperty(value = "Success result", allowableValues = "0,1", required = true)
	private int success;
}
