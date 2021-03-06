package com.digi.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.nonNull;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
@ApiModel(value="ExceptionResponse", description="Exception Response `success = false`")
public class ExceptionResponse extends SuccessResultResponse {
	@JsonIgnore
	private Exception ex;

	private String error;
	private String message;
	private String cause;

	public ExceptionResponse(Exception ex){
		setSuccess(0);
		setEx(ex);
		setError(ex.getClass().getSimpleName());
		setMessage(ex.getMessage());
		setCause(nonNull(ex.getCause()) ? ex.getCause().getMessage() : null);
		log.error(ex.getMessage(), ex);
	}
}
