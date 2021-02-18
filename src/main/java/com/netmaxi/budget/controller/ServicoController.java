package com.netmaxi.budget.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netmaxi.budget.model.Servico;
import com.netmaxi.budget.repository.ServicoRepository;

@RestController
@RequestMapping(path = "/servicos")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Servico> servicos = servicoRepository.findAll();
		return !servicos.isEmpty() ? ResponseEntity.ok(servicos) : ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Servico> criar(@RequestBody Servico servico, HttpServletResponse response) {
		Servico servicoCriado = servicoRepository.save(servico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(servicoCriado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(servicoCriado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Servico>> buscarPorID(@PathVariable Long id) {
		
		Optional<Servico> servicoEncontrado = servicoRepository.findById(id);
		
		return servicoEncontrado.isPresent() ? ResponseEntity.ok().body(servicoEncontrado) : ResponseEntity.notFound().build();
	}
	
	
	
}
