package com.digi;

import com.digi.entity.request.AccountToConfirm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tymoshenkol on 12-Oct-16.
 */
@Slf4j
public class StringTest {

	@Test
	public void testConfirmationCode(){
		AccountToConfirm acc = new AccountToConfirm("D\nM\t.*+)$#BW-2T-XC5456456-NLДывыdsfvddf/dfb?dfbвäöKKмывъїє");
		log.debug("clearConfirmationCode: {}", acc.clearConfirmationCode());
		assertThat(acc.clearConfirmationCode()).isEqualTo("DMBW2TXC5456456NLДЫВЫDSFVDDFDFBDFBВÄÖKKМЫВЪЇЄ");
	}
}
