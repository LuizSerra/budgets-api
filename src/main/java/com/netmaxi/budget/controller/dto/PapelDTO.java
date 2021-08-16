package com.netmaxi.budget.controller.dto;

import org.springframework.data.domain.Page;

import com.netmaxi.budget.model.Papel;

public class PapelDTO {
	
	public PapelDTO() {}
	
	public PapelDTO(Papel papel) {
		this.id = papel.getId();
		this.nome = papel.getNome();
	}

	private Long id;
	private String nome;
	
	
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static Page<PapelDTO> convertToPapelDTOList(Page<Papel> papeis) {
		return papeis.map(PapelDTO::new);
	}

}
