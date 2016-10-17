package com.digi.utils;

import com.digi.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tymoshenkol on 12-Oct-16.
 */
@Slf4j
public class StrUtilTest {

	String strToClear = "D\nM\t.*+)$#BW-2T-XC5456456-NLДывыdsfvddf/dfb?dfbвäöKKмывъїє".toUpperCase();

	@Test
	public void testConfirmationCode () {
		String code = StrUtil.clearNonAlphabeticNonDigit(strToClear);
		assertThat(code).isEqualTo("DMBW2TXC5456456NLДЫВЫDSFVDDFDFBDFBВÄÖKKМЫВЪЇЄ");
	}

	@Test
	public void testConfirmationCodeNumeric () {
		String code = StrUtil.clearNonDigit(strToClear);
		assertThat(code).isEqualTo("25456456");
	}
}
