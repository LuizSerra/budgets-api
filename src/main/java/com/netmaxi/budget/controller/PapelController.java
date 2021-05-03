package com.netmaxi.budget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netmaxi.budget.model.Papel;
import com.netmaxi.budget.service.PapelService;
import com.softplan.core.model.Permissao;

@RestController
@RequestMapping(path = "/permissoes")
public class PapelController {
	
	@Autowired
	PapelService papelService;

	@GetMapping
    public ResponseEntity<List<Papel>> getAllpermissions(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy) 
    {
        List<Permissao> permissoes = papelService.getAllPermissons(pageNo, pageSize, sortBy);
 
        return !permissoes.isEmpty() ? ResponseEntity.ok(permissoes) : ResponseEntity.noContent().build();
    }
	
	
}
