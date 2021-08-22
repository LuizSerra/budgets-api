package com.netmaxi.budget.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import com.netmaxi.budget.config.security.TokenService;
import com.netmaxi.budget.controller.dto.TokenDTO;
import com.netmaxi.budget.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm login) {
		System.out.println(login.getEmail() + " - " + login.getSenha());
		UsernamePasswordAuthenticationToken dadosLogin = login.converter();
		
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token =  tokenService.gerarToken(authenticate);
			System.out.println(token);
			
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));		
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
