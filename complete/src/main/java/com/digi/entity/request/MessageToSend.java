package com.digi.entity.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="MessageToSend", description="SMS message")
public class MessageToSend implements Serializable {
	@ApiModelProperty(value = "Phone number", example = "14053264519", required = true)
	private String to;
	@ApiModelProperty(value = "SMS - body text", example = "TLV: test message =)", required = true)
	private String text;
}
