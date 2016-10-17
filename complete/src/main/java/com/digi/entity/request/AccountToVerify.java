package com.digi.entity.request;


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
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="AccountToVerify", description="Sample model for auth user by phone number")
public class AccountToVerify implements Serializable {
	@ApiModelProperty(value = "Phone number", example = "14053264519", required = true)
	@NonNull private String phone;
	@ApiModelProperty(value = "CallBack notification url, if needed", example = "http://test.com")
	private String callBackUri;
	@ApiModelProperty(value = "CallBack notification Method, if needed", example = "GET")
	private String callBackMethod;
}
