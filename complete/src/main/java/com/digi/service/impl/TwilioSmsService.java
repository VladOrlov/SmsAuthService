package com.digi.service.impl;

import com.digi.config.Administrator;
import com.digi.config.TwilioCredentials;
import com.digi.entity.request.MessageToSend;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.digi.util.TwilioMessageCreator;
import javax.inject.Inject;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@Slf4j
public class TwilioSmsService {

	private final Administrator administrator;
	private final TwilioCredentials credentials;

	private TwilioMessageCreator messageCreator;

	public Message sendAdminMessage (String message) {
		return sendMessage(administrator.getPhoneNumber(), message);
	}

	private TwilioMessageCreator messageCreator () {
		if(messageCreator == null) {
			return new TwilioMessageCreator(
					new TwilioRestClient.Builder(
							credentials.getAccountSid(),
							credentials.getAuthToken()
					).build()
			);
		} return messageCreator;
	}

	public Message sendMessage (String to, String message) {
		return sendMessage(to, message, null);
	}

	public Message sendMessage (String to, String message, String mediaUrl) {
		return messageCreator().create(to, credentials.getPhoneNumber(), message, mediaUrl);
	}

	public Message sendMessage (MessageToSend message) {
		return sendMessage(message.getTo(), message.getText());
	}
}
