package com.digi.service.impl;

import com.digi.config.app.RandomKeyConfig;
import com.digi.service.RandomService;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static org.bitbucket.dollar.Dollar.$;


@Service
@Getter
@Accessors(fluent = true)
@Slf4j
public class DefaultRandomService implements RandomService {

	@Autowired
	private RandomKeyConfig config;
	private String validCharacters;

	public String validCharacters () {
		if (isNull(validCharacters)) {
			validCharacters = $('0', '9').join() + (config.getWithLetters() ? $('A', 'Z').join() : "");
		}
		return validCharacters;
	}

	public String generateCode () {
		return $(validCharacters()).shuffle().slice(config.getSize()).toString();
	}

	public String customizeCode (String code) {
		return String.join(config.getDelimiter(),
				code.split("(?<=\\G.{" + config.getPartitionSize() + "})")
		);
	}


}
