package com.digi.entity.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.twilio.rest.api.v2010.account.Message;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.nonNull;

/**
 * Created by tymoshenkol on 18-Oct-16.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
@ApiModel(value="ExceptionResponse", description="Exception Response `success = false`")
public class MessageResponse {
	com.twilio.rest.api.v2010.account.Message twilio;
	com.clickatell.entity.Message click;
	String messageID;
	String messageStatus;
	String messageStatusDescription;

	private MessageResponse (com.twilio.rest.api.v2010.account.Message fromTwilio) {
		this.twilio = fromTwilio;
		messageID = twilio.getSid();
		messageStatus = twilio.getStatus().name();
		messageStatusDescription = twilio.getStatus().toString();
	}

	private MessageResponse (com.clickatell.entity.Message fromClick) {
		this.click = fromClick;
		messageID = click.getApiMessageId();
		messageStatus = click.getMessageStatus();
	}

	public static MessageResponse of (com.twilio.rest.api.v2010.account.Message twilio) {return new MessageResponse(twilio);}

	public static MessageResponse of (com.clickatell.entity.Message click) {return new MessageResponse(click);}

	public String getMessageID () {
		return messageID;
	}

	public boolean isMessageQueued (){
		if(nonNull(twilio) && twilio.getStatus().equals(Message.Status.QUEUED))
			return true;
		else if(nonNull(click) && click.getMessageStatus().equalsIgnoreCase("003"))
			return true;
		else
			return false;

	}
}
