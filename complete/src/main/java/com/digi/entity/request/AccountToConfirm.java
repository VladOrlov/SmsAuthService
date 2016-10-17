package com.digi.entity.request;


import com.digi.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 25-Aug-16.
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="AccountToConfirm", description="Sample model for confirmation")
public class AccountToConfirm extends AccountToVerify {
	@ApiModelProperty(value = "Verification code", example = "CW-7T-86-3H", required = true)
	@NonNull private String code;

	public String clearConfirmationCode(){
		return StrUtil.clearNonAlphabeticNonDigit(getCode().toLowerCase()).toUpperCase();
	}
}
