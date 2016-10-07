package com.digi.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
@ApiModel(value="SuccessResponse", description="Response in case `success = true`")
public class SuccessResponse extends SuccessResultResponse {
	@ApiModelProperty(value = "If success return some additional data as `result`")
	private Object result;

	public SuccessResponse(Object data){
		setSuccess(1);
		setResult(data);
	}
}
