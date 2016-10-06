package com.digi.controller;

import com.digi.entity.db.PhoneAuthLog;
import com.digi.entity.request.AccountToVerify;
import com.digi.entity.response.SuccessResponse;
import com.digi.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@Slf4j
@RequestMapping("/account")
public class AuthController {

	private final AuthService authService;

	@RequestMapping(value = "/Authorise", method = RequestMethod.POST)
	public ResponseEntity<SuccessResponse> authorise (@RequestBody AccountToVerify account) {
		PhoneAuthLog acc = authService.authorise(account);
		return ResponseEntity.ok().body(new SuccessResponse(acc));
	}

	@RequestMapping(value = "/Confirm", method = RequestMethod.POST)
	public ResponseEntity<SuccessResponse> confirm (@RequestBody AccountToVerify account) {
		PhoneAuthLog acc = authService.confirm(account);
		return ResponseEntity.ok().body(new SuccessResponse(acc));
	}
}
