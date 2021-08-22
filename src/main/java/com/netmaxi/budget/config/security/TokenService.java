package com.netmaxi.budget.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authenticate) {
		Usuario usuario  = (Usuario) authenticate.getPrincipal();
		Date dataCriacao = new Date();
		Date dataExpiracao = new Date(dataCriacao.getTime() + Long.valueOf(expiration));
				
		
		return Jwts.builder()
				.setIssuer("BUDGET_API")
				.setSubject(usuario.getId().toString())
				.setIssuedAt(dataCriacao)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
