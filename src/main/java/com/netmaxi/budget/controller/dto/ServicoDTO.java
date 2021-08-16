package com.netmaxi.budget.controller.dto;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;

import com.netmaxi.budget.model.ItemServico;
import com.netmaxi.budget.model.Servico;

public class ServicoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private String unidade;
	private BigDecimal valorUnitario;
	List<ItemServico> itens;
	
	
	public ServicoDTO(Servico servico) {
		this.id = servico.getId();
		this.nome = servico.getNome();
		this.descricao = servico.getDescricao();
		this.unidade = servico.getUnidade();
		this.valorUnitario = servico.getValorUnitario();
		this.itens = servico.getItens();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getUnidade() {
		return unidade;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public List<ItemServico> getItens() {
		return itens;
	}
	
	public static Page<ServicoDTO> convertToServicoDTOList(Page<Servico> servicos) {
		return servicos.map(ServicoDTO::new);
	}
	

}
