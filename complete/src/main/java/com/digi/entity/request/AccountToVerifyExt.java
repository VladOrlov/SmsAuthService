package com.digi.entity.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 25-Aug-16.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ApiModel(value="AccountToVerifyExt", description="Send sms with special text!")
public class AccountToVerifyExt extends AccountToVerify {
	@ApiModelProperty(value = "Sms Template")
	@NonNull private SmsTemplate template;
}
