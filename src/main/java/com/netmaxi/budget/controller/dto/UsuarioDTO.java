package com.netmaxi.budget.controller.dto;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.netmaxi.budget.model.Orcamento;
import com.netmaxi.budget.model.Papel;
import com.netmaxi.budget.model.Servico;
import com.netmaxi.budget.model.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private boolean ativo;
	private List<Papel> papeis;
	private Set<Orcamento> orcamento;
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.ativo = usuario.isAtivo();
		this.papeis = usuario.getPapeis();
		this.orcamento = usuario.getOrcamento();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public Set<Orcamento> getOrcamento() {
		return orcamento;
	}

	public static Page<UsuarioDTO> convertToUsuarioDTOList(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDTO::new);
	}
	
}
