package com.login.cadastro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import com.login.cadastro.security.JwtService;

@SpringBootTest
public class JwtServiceTest {

	@Autowired
	private JwtService jwtService;

	@Test
	public void deveGerarToken() {
		String token = jwtService.generateToken("henrique@email.com");
		Assertions.assertNotNull(token);

	}
}
