package com.digi.service.impl;

import com.digi.config.RandomKeyConfig;
import com.digi.service.RandomService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import static org.bitbucket.dollar.Dollar.$;


@Service
@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@Slf4j
public class DefaultRandomService implements RandomService{

	private final RandomKeyConfig config;
	private String validCharacters;

	public String validCharacters () {
		if (validCharacters == null) {
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
