package com.netmaxi.budget.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netmaxi.budget.model.Cliente;
import com.netmaxi.budget.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		return !clientes.isEmpty() ? ResponseEntity.ok(clientes) : ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteriado = clienteRepository.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(clienteriado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(clienteriado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> buscarPorID(@PathVariable Long id) {
		
		Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
		
		return clienteEncontrado.isPresent() ? ResponseEntity.ok().body(clienteEncontrado) : ResponseEntity.notFound().build();
	}

}
