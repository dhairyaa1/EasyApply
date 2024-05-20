package com.easyapply.loginservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginServiceApplicationTests {

	@Autowired
	private ServerProperties serverProperties;
	@Test
	void contextLoads() {
		assertEquals(7777, serverProperties.getPort());
	}

}
