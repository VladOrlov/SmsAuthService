package com.digi.entity.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tymoshenkol on 25-Aug-16.
 */
@Getter
@Setter
@ApiModel(value="MessageToSend", description="SMS message")
public class MessageToSend implements Serializable {
	@ApiModelProperty(value = "Phone number", example = "14053264519", required = true)
	private String to;
	@ApiModelProperty(value = "SMS - body text", example = "TLV: test message =)", required = true)
	private String text;
}
