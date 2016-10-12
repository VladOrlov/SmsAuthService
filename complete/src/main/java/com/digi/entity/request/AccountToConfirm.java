package com.digi.entity.request;


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
@ApiModel(value="AccountToConfirm", description="Sample model for confirmation")
public class AccountToConfirm extends AccountToVerify {
	@ApiModelProperty(value = "Verification code", example = "CW-7T-86-3H", required = true)
	@NonNull private String code;

	public String clearConfirmationCode(){
		return (getCode().toLowerCase()).replaceAll("[^\\p{IsAlphabetic}^\\p{IsDigit}]", "").toUpperCase();
	}
}
