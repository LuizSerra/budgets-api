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

import com.netmaxi.budget.controller.dto.ItemServicoDTO;
import com.netmaxi.budget.model.ItemServico;
import com.netmaxi.budget.service.ItemServicoService;

@RestController
@RequestMapping(path = "/itens")
public class ItemServicoController {
	
	@Autowired
	ItemServicoService itemServicoService;
		
	@GetMapping
	public ResponseEntity<Page<ItemServicoDTO>> listar(Pageable pagination) {
		Page<ItemServicoDTO> itemServicos = ItemServicoDTO.convertToItemServicoDTOList(itemServicoService.listar(pagination));
        return !itemServicos.isEmpty() ? ResponseEntity.ok(itemServicos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/servico/{servId}/orcamento/{orcamId}")
	public ResponseEntity<?> getItemServicoPorId(@PathVariable Long servId, @PathVariable Long orcamId ) {
		Optional<ItemServico> itemServicoEncontrado = itemServicoService.getItemServicoPorIds(servId, orcamId);
		return itemServicoEncontrado.isPresent() ? ResponseEntity.ok(new ItemServicoDTO(itemServicoEncontrado.get())) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");  
	}
	
	@GetMapping("/orcamento/{id}")
	public ResponseEntity<Page<ItemServicoDTO>> listarItemPorOrcamentoId(@PathVariable Long id, Pageable pagination) {
		Page<ItemServicoDTO> itemServicos = ItemServicoDTO.convertToItemServicoDTOList(itemServicoService.listarPorOrcamentoId(id, pagination));
        return !itemServicos.isEmpty() ? ResponseEntity.ok(itemServicos) : ResponseEntity.noContent().build(); 
	}
	
	@GetMapping("/servico/{id}")
	public ResponseEntity<Page<ItemServicoDTO>> listarItemPorServicoId(@PathVariable Long id, Pageable pagination) {
		Page<ItemServicoDTO> itemServicos = ItemServicoDTO.convertToItemServicoDTOList(itemServicoService.listarPorServicoId(id, pagination));
        return !itemServicos.isEmpty() ? ResponseEntity.ok(itemServicos) : ResponseEntity.noContent().build(); 
	}
	
		
	@PostMapping
	public ResponseEntity<ItemServico> criar(@Valid @RequestBody ItemServico itemServico, HttpServletResponse response) {
		ItemServico itemServicoCriado = itemServicoService.criar(itemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(itemServicoCriado.getId()).toUri();
		return ResponseEntity.created(uri).body(itemServicoCriado);
	}
	
	@PutMapping("/servico/{servId}/orcamento/{orcamId}")
	public ResponseEntity<ItemServico> atualizar(@PathVariable Long servId, @PathVariable Long orcamId, @RequestBody ItemServico itemServico )  {
		ItemServico itemServicoCriado = itemServicoService.atualizar(servId, orcamId, itemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(itemServicoCriado.getId()).toUri();
		return ResponseEntity.created(uri).body(itemServicoCriado);
	}
	
	@DeleteMapping("/servico/{servId}/orcamento/{orcamId}")
	public ResponseEntity<?> remover(@PathVariable Long servId, @PathVariable Long orcamId) {
		return itemServicoService.delete(servId, orcamId); 
	}
}
