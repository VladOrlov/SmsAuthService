package com.digi.service.impl;

import com.digi.config.smsprovider.ClickatellCredentials;
import com.digi.config.smsprovider.TwilioCredentials;
import com.digi.entity.exception.SmsProviderSettingsNotFound;
import com.digi.service.ProviderFactory;
import com.digi.service.SmsService;
import com.digi.service.impl.smsprovider.ClickatellSmsService;
import com.digi.service.impl.smsprovider.TwilioSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * Created by tymoshenkol on 19-Oct-16.
 */
@Slf4j
@Service
public class SmsProviderFactory implements ProviderFactory {

	private static SmsService smsService;
	@Autowired
	private TwilioCredentials twilioCfg;
	@Autowired
	private ClickatellCredentials clickatellCfg;

	public SmsService get () {
		if (isNull(smsService)) {
			if (twilioCfg.isValid())
				return TwilioSmsService.of(twilioCfg);
			else if (clickatellCfg.isValid())
				return ClickatellSmsService.of(clickatellCfg);
			else
				throw new SmsProviderSettingsNotFound();
		}
		return smsService;
	}
}
