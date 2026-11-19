package com.login.cadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.login.cadastro.security.JwtService;

import io.jsonwebtoken.security.SignatureException;

@SpringBootTest
public class JwtServiceTest {

	@Autowired
	private JwtService jwtService;

	@Test
	public void deveGerarToken() {
		String token = jwtService.generateToken("henrique@email.com");
		Assertions.assertNotNull(token);

	}
	
	@Test
	public void deveExtrairUsernameDoToken() {
		String valorEsperado = "henrique@email.com";
		String token = jwtService.generateToken(valorEsperado);
		String valorObtido = jwtService.extractUsername(token);
		
		Assertions.assertEquals(valorEsperado, valorObtido);
	}
	
	@Test
	public void deveRejeitarTokenAdulterado() {
		String token = jwtService.generateToken("henrique@email.com");
		String tokenAletrado = token.replace("a", "b");
		
		Assertions.assertThrows(SignatureException.class,() -> {
			jwtService.extractUsername(tokenAletrado);
		});
	}
}
