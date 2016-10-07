package com.digi.service;

import com.digi.config.RandomKeyConfig;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import static org.bitbucket.dollar.Dollar.$;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
@Slf4j
public class RandomService {

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
