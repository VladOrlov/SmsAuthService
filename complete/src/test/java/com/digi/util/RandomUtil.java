package com.digi.util;

import com.digi.config.RandomKeyConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;

import static org.bitbucket.dollar.Dollar.$;

/**
 * Created by tymoshenkol on 06-Oct-16.
 */
@Slf4j
public class RandomUtil {

	@Test
	public void testGenerator () {
		String s = UUID.randomUUID().toString();
		log.debug("uuid: {}", s);

		//RandomKeyConfig cfg = new RandomKeyConfig(6, 3, "~");

		for(int i=1; i<10; i++){
			//log.debug("s: {}", randomString(cfg.getSize()));
		}


	}
	String randomString(int length) {
		String validCharacters = $('0', '9').join(); // + $('A', 'Z').join();
		String s = $(validCharacters).shuffle().slice(10).toString();

		return s;
	}

	}
