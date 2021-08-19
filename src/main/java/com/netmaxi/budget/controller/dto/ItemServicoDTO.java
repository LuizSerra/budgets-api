package com.netmaxi.budget.controller.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import com.netmaxi.budget.model.ItemServico;
import com.netmaxi.budget.model.ItemServico.Id;
import com.netmaxi.budget.model.Orcamento;
import com.netmaxi.budget.model.Servico;

public class ItemServicoDTO {
	
	private Id id;
	private double quantidade;
	private BigDecimal valorTotal;
	private Orcamento orcamento;
	private Servico servico;
	
	public ItemServicoDTO(ItemServico itemServico) {
		this.id = itemServico.getId();
		this.quantidade = itemServico.getQuantidade();
		this.valorTotal = itemServico.getValorTotal();
		this.orcamento = itemServico.getOrcamento();
		this.servico = itemServico.getServico();
	}

	public Id getId() {
		return id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public Servico getServico() {
		return servico;
	}
	
	public static Page<ItemServicoDTO> convertToItemServicoDTOList(Page<ItemServico> itemServicos) {
		return itemServicos.map(ItemServicoDTO::new);
	}

}
