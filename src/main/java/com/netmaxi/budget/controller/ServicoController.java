package com.netmaxi.budget.controller;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netmaxi.budget.controller.dto.ServicoDTO;
import com.netmaxi.budget.model.Servico;
import com.netmaxi.budget.service.ServicoService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(path = "/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	@GetMapping
	public ResponseEntity<Page<ServicoDTO>> listar(String search, Boolean ativo, Pageable pagination) {
		Page<ServicoDTO> servicos = ServicoDTO.convertToServicoDTOList(servicoService.listar(search, ativo, pagination));
        return !servicos.isEmpty() ? ResponseEntity.ok(servicos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getServicoPorId(@PathVariable Long id) {
		Optional<Servico> servicoEncontrado = servicoService.getServicoPorId(id);
		return servicoEncontrado.isPresent() ? ResponseEntity.ok(new ServicoDTO(servicoEncontrado.get())) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");  
	}

	@PostMapping
	public ResponseEntity<Servico> criar(@Valid @RequestBody Servico servico, HttpServletResponse response) {
		Servico servicoCriado = servicoService.criar(servico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(servicoCriado.getId()).toUri();
		return ResponseEntity.created(uri).body(servicoCriado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Servico> atualizar(@PathVariable Long id, @Valid @RequestBody Servico servico, HttpServletResponse response) {
		Servico servicoAtualizado = servicoService.atualizar(id, servico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(servicoAtualizado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(servicoAtualizado);
	}
	
	@ApiIgnore
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return servicoService.delete(id);  
	}
	
}
