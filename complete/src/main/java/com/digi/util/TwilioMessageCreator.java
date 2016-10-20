package com.digi.util;

import com.twilio.exception.ApiException;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.nonNull;

@Slf4j
public class TwilioMessageCreator {
	private final TwilioRestClient client;

	public TwilioMessageCreator (TwilioRestClient client) {
		this.client = client;
	}

	public Message create (String to, String from, String body, String mediaUrl) {
		MessageCreator messageCreator = new MessageCreator(
				new PhoneNumber(to),
				new PhoneNumber(from),
				body);
		if (nonNull(mediaUrl))
			messageCreator.setMediaUrl(mediaUrl);

		Message message = messageCreator.create(this.client);
		log.debug("messageCreator.create: {}", message);
		return message;
	}
}

