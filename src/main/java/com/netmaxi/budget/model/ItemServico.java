package com.netmaxi.budget.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "itemServico")
@Table(name="item_servico")
public class ItemServico {
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id_orcamento", column = @Column(name = "id_orcamento", nullable = false)),
			@AttributeOverride(name = "id_servico", column = @Column(name = "id_servico", nullable = false)) })
	private Id id;
	
	private double quantidade;
	
	@Transient
	private BigDecimal valorTotal;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_orcamento", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Orcamento orcamento;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_servico", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Servico servico;
	
	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return BigDecimal.valueOf(this.quantidade * this.servico.getValorUnitario().doubleValue());
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}


	// Id da associacao (chave composta no banco)
		@Embeddable
		public static class Id implements Serializable {

			/**
				 * 
				 */
			private static final long serialVersionUID = 6020117944096559128L;

			@Column(name = "id_orcamento", nullable = false)
			private Long idOrcamento;

			@Column(name = "id_servico", nullable = false)
			private Long idServico;

			public Long getIdOrcamento() {
				return idOrcamento;
			}

			public void setIdOrcamento(Long idOrcamento) {
				this.idOrcamento = idOrcamento;
			}

			public Long getIdServico() {
				return idServico;
			}

			public void setIdServico(Long idServico) {
				this.idServico = idServico;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((idOrcamento == null) ? 0 : idOrcamento.hashCode());
				result = prime * result + ((idServico == null) ? 0 : idServico.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Id other = (Id) obj;
				if (idOrcamento == null) {
					if (other.idOrcamento != null)
						return false;
				} else if (!idOrcamento.equals(other.idOrcamento))
					return false;
				if (idServico == null) {
					if (other.idServico != null)
						return false;
				} else if (!idServico.equals(other.idServico))
					return false;
				return true;
			}
		
		}
	
	
}
