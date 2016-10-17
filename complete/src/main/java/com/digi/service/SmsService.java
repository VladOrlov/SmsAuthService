package com.digi.service;

import com.digi.entity.request.MessageToSend;
import com.twilio.rest.api.v2010.account.Message;

public interface SmsService {

	Message sendAdminMessage (String message);

	Message sendMessage (String to, String message);

	Message sendMessage (String to, String message, String mediaUrl);

	Message sendMessage (MessageToSend message);
}
