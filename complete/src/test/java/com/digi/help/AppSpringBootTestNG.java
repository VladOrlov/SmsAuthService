package com.digi.help;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by tymoshenkol on 17-Oct-16.
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Slf4j(topic = "TEST:TestNG")
public class AppSpringBootTestNG extends AbstractTestNGSpringContextTests {

}
