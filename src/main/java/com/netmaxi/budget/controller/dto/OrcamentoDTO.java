package com.netmaxi.budget.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;

import com.netmaxi.budget.model.ItemServico;
import com.netmaxi.budget.model.Orcamento;
import com.netmaxi.budget.model.StatusOrcamento;
import com.netmaxi.budget.model.Usuario;

public class OrcamentoDTO {

	private Long id;
	private String nome;
	private LocalDate dataAbertura;
	private LocalDate dataFechamento;
	private StatusOrcamento status;
	private String observacao;
	private BigDecimal valorFinal;
	private boolean ativo;
    private Usuario usuario;
	private List<ItemServico> itens;
	
	public OrcamentoDTO(Orcamento orcamento) {
		super();
		this.id = orcamento.getId();
		this.nome = orcamento.getNome();
		this.dataAbertura = orcamento.getDataAbertura();
		this.dataFechamento = orcamento.getDataAbertura();
		this.status = orcamento.getStatus();
		this.observacao = orcamento.getObservacao();
		this.valorFinal = orcamento.getValorFinal();
		this.ativo = orcamento.isAtivo();
		this.usuario = orcamento.getUsuario();
		this.itens = orcamento.getItens();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public StatusOrcamento getStatus() {
		return status;
	}

	public String getObservacao() {
		return observacao;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<ItemServico> getItens() {
		return itens;
	}
	
	public static Page<OrcamentoDTO> convertToOrcamentoDTOList(Page<Orcamento> orcamentos) {
		return orcamentos.map(OrcamentoDTO::new);
	}

	

}
