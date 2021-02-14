package com.netmaxi.budget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmaxi.budget.model.Servico;
import com.netmaxi.budget.repository.ServicoRepository;

@RestController
@RequestMapping(path = "/servicos")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Servico> servicos = servicoRepository.findAll();
		return !servicos.isEmpty() ? ResponseEntity.ok(servicos) : ResponseEntity.noContent().build();
	}
}
