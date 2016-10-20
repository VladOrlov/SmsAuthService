package com.digi.service;

import com.digi.config.app.Administrator;
import com.digi.entity.request.MessageToSend;
import com.digi.entity.response.MessageResponse;

public interface SmsService {

	MessageResponse sendAdminMessage (String message, Administrator administrator);

	MessageResponse sendMessage (String to, String message);

	MessageResponse sendMessage (String to, String message, String mediaUrl);

	MessageResponse sendMessage (MessageToSend message);
}
