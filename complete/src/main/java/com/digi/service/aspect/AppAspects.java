package com.digi.service.aspect;

import com.digi.entity.exception.NotEnoughData;
import com.digi.entity.request.AccountToVerify;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;


/**
 * Created by tymoshenkol on 06-Oct-16.
 */
@Aspect
@Component
@Slf4j
public class AppAspects {

	@Before("execution(public * com.digi.service.impl.DefaultAuthService.*(..)) && args(account)")
	public void beforeAuthService (AccountToVerify account) {
		if (isNull(account) || isNull(account.getPhone()) || account.getPhone().isEmpty()) {
			throw new NotEnoughData();
		}
		log.debug("beforeAuthService: account={}", account);
	}
}
