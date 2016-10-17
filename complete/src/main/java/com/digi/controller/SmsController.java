package com.digi.controller;

import com.digi.entity.request.MessageToSend;
import com.digi.service.impl.TwilioSmsService;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Calendar;

@RestController
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@Slf4j
@RequestMapping("/sms")
public class SmsController {

	private final TwilioSmsService smsService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ResponseEntity<Message> testAdmin () {
		Message m = smsService.sendAdminMessage("TLV: test message from " + Calendar.getInstance().getTime());
		return ResponseEntity.ok().body(m);
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<Message> sendMessage (@RequestBody MessageToSend message) {
		Message m = smsService.sendMessage(message);
		return ResponseEntity.ok().body(m);
	}

}
