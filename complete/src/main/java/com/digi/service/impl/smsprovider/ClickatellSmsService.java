package com.digi.service.impl.smsprovider;


import com.clickatell.entity.Message;
import com.clickatell.sdk.ClickatellRest;
import com.clickatell.sdk.ClickatellSdk;
import com.digi.config.Administrator;
import com.digi.config.smsprovider.ClickatellCredentials;
import com.digi.entity.request.MessageToSend;
import com.digi.entity.response.MessageResponse;
import com.digi.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
@Slf4j
class ClickatellSmsService implements SmsService {

	private ClickatellCredentials credentials;
	private ClickatellSdk clickatell;

	private ClickatellSmsService (ClickatellCredentials credentials) {
		this.credentials = credentials;
		this.clickatell = ClickatellRest.of(credentials.getAuthToken());
	}

	public static ClickatellSmsService of (ClickatellCredentials credentials) {return new ClickatellSmsService(credentials);}

	@Override
	public MessageResponse sendAdminMessage (String message, Administrator administrator) {
		requireNonNull(administrator);
		requireNonNull(administrator.getPhoneNumber());
		return sendMessage(administrator.getPhoneNumber(), message);
	}

	@Override
	public MessageResponse sendMessage (String to, String message) {
		Message response = clickatell.sendMessage(to, message);
		return MessageResponse.of(response);
	}

	@Override
	public MessageResponse sendMessage (String to, String message, String mediaUrl) {
		log.error("Clickatell doesnt support \"mediaUrl\" parameter.");
		return sendMessage(to, message);
	}

	@Override
	public MessageResponse sendMessage (MessageToSend message) {
		return sendMessage(message.getTo(), message.getText());
	}


}
