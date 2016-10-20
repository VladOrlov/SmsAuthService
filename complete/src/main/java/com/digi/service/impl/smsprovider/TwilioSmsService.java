package com.digi.service.impl.smsprovider;

import com.digi.config.app.Administrator;
import com.digi.config.smsprovider.TwilioCredentials;
import com.digi.entity.request.MessageToSend;
import com.digi.entity.response.MessageResponse;
import com.digi.service.SmsService;
import com.digi.util.TwilioMessageCreator;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

@Service
@Slf4j
class TwilioSmsService implements SmsService {

	private TwilioCredentials credentials;
	private TwilioMessageCreator messageCreator;

	private TwilioSmsService (TwilioCredentials credentials) {
		this.credentials = credentials;
	}

	public static TwilioSmsService of (TwilioCredentials credentials) {return new TwilioSmsService(credentials);}

	public MessageResponse sendAdminMessage (String message, Administrator administrator) {
		requireNonNull(administrator);
		requireNonNull(administrator.getPhoneNumber());
		return sendMessage(administrator.getPhoneNumber(), message);
	}


	public MessageResponse sendMessage (String to, String message) {
		return sendMessage(to, message, null);
	}

	public MessageResponse sendMessage (String to, String message, String mediaUrl) {
		Message response = messageCreator().create(to, credentials.getPhoneNumber(), message, mediaUrl);
		return MessageResponse.of(response);
	}

	public MessageResponse sendMessage (MessageToSend message) {
		return sendMessage(message.getTo(), message.getText());
	}

	//Twilio feature:
	private TwilioMessageCreator messageCreator () {
		if (isNull(messageCreator)) {
			return new TwilioMessageCreator(
					new TwilioRestClient.Builder(
							credentials.getAccountSid(),
							credentials.getAuthToken()
					).build()
			);
		}
		return messageCreator;
	}
}
