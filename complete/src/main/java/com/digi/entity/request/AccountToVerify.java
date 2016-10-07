package com.digi.entity.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 25-Aug-16.
 */
@Data
@RequiredArgsConstructor
@ApiModel(value="AccountToVerify", description="Sample model for auth user by phone number")
public class AccountToVerify implements Serializable {
	@ApiModelProperty(value = "Phone number", example = "14053264519", required = true)
	@NonNull private String phone;
}
