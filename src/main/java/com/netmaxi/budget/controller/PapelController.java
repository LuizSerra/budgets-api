package com.netmaxi.budget.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmaxi.budget.controller.dto.PapelDTO;
import com.netmaxi.budget.model.Papel;
import com.netmaxi.budget.service.PapelService;

@RestController
@RequestMapping(path = "/papeis")
public class PapelController {
	
	@Autowired
	PapelService papelService;

	@GetMapping
    public ResponseEntity<Page<PapelDTO>>listar(String search, Pageable pagination)   {
		Page<PapelDTO> papeis = PapelDTO.convertToPapelDTOList(papelService.listar(search, pagination));
        return !papeis.isEmpty() ? ResponseEntity.ok(papeis) : ResponseEntity.noContent().build();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPapelPorId(@PathVariable Long id) {
		Optional<Papel> papelEncontrado = papelService.getPapelPorId(id);
		return papelEncontrado.isPresent() ? ResponseEntity.ok(new PapelDTO(papelEncontrado.get())) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");  
	}
	
}
