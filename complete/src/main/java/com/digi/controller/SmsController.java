package com.digi.controller;

import com.digi.config.Administrator;
import com.digi.entity.request.MessageToSend;
import com.digi.entity.response.MessageResponse;
import com.digi.service.impl.smsprovider.SmsProviderFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@Slf4j
@RequestMapping("/sms")
public class SmsController {
	@Autowired
	private SmsProviderFactory provider;

	@Autowired
	private Administrator administrator;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ResponseEntity<MessageResponse> testAdmin () {
		MessageResponse m = provider.get().sendAdminMessage("TLV: test message from " + Calendar.getInstance().getTime(), administrator);
		return ResponseEntity.ok().body(m);
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> sendMessage (@RequestBody MessageToSend message) {
		MessageResponse m = provider.get().sendMessage(message);
		return ResponseEntity.ok().body(m);
	}

}
