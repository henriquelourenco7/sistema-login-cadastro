package com.login.cadastro.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	@Value("${jwt.secret}")
	private String secretKey;

	private SecretKey getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String generateToken(String email) {

		Date dataAtual = new Date();

		Date dataExpiracao = new Date(dataAtual.getTime() + (60 * 24) * (60 * 1000));
		
		return Jwts.builder()
			.subject(email)
			.issuedAt(dataAtual)
			.expiration(dataExpiracao)
			.signWith(getSignInKey())
			.compact();

	}
}
