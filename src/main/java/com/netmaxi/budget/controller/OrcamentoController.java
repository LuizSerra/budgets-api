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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netmaxi.budget.controller.dto.OrcamentoDTO;
import com.netmaxi.budget.model.Orcamento;
import com.netmaxi.budget.service.OrcamentoService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(path = "/orcamentos")
public class OrcamentoController {
	
	@Autowired
	OrcamentoService orcamentoService;
	
	@GetMapping
	public ResponseEntity<Page<OrcamentoDTO>> listar(String search, Boolean ativo, Pageable pagination) {
		Page<OrcamentoDTO> usuarios = OrcamentoDTO.convertToOrcamentoDTOList(orcamentoService.listar(search, ativo, pagination));
        return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrcamentoPorId(@PathVariable Long id) {
		Optional<Orcamento> orcamentoEncontrado = orcamentoService.getOrcamentoPorId(id);
		return orcamentoEncontrado.isPresent() ? ResponseEntity.ok(new OrcamentoDTO(orcamentoEncontrado.get())) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");  
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Page<OrcamentoDTO>> listarOrcamentoPorUsuarioId(@PathVariable Long id, Pageable pagination) {
		Page<OrcamentoDTO> orcamentos = OrcamentoDTO.convertToOrcamentoDTOList(orcamentoService.listarOrcamentoPorUsuarioId(id, pagination));
        return !orcamentos.isEmpty() ? ResponseEntity.ok(orcamentos) : ResponseEntity.noContent().build(); 
	}
	
	@PostMapping
	public ResponseEntity<Orcamento> criar(@RequestBody Orcamento orcamento, HttpServletResponse response) {
		Orcamento orcamentoCriado = orcamentoService.criar(orcamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(orcamentoCriado.getId()).toUri();
		return ResponseEntity.created(uri).body(orcamentoCriado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Orcamento> atualizar(@PathVariable Long id, @Valid @RequestBody Orcamento orcamento, HttpServletResponse response) {
		Orcamento orcamentoAtualizado = orcamentoService.atualizar(id, orcamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(orcamentoAtualizado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(orcamentoAtualizado);
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Orcamento> atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody boolean ativo){
		Orcamento orcamentoAtualizado =	orcamentoService.atualizarStatus(id, ativo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(orcamentoAtualizado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(orcamentoAtualizado);
	}
	
	@ApiIgnore
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
		orcamentoService.delete(id);
	}
}
