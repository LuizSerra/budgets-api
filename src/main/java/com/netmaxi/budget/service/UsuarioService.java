package com.netmaxi.budget.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Usuario;
import com.netmaxi.budget.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Page<Usuario> listar(String search, Pageable pagination) {
		if (search == null)
			return usuarioRepository.findAll(pagination);
		return usuarioRepository.findByNomeContaining(search, pagination);
	}

	public Page<Usuario> getAllUsersActive(String search, Pageable pagination) {
		if (search == null)
			return usuarioRepository.findByAtivoTrue(pagination);
		return usuarioRepository.findByNomeContainingAndAtivoTrue(search, pagination);
	}
	
	public Optional<Usuario> getUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario criar(Usuario usuario) {
		usuario.setAtivo(true);
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		Optional<Usuario> usuarioBuscado = getUsuarioPorId(id);
		Usuario usuarioEncontrado = null;
		if (usuarioBuscado.isPresent()) {
			usuarioEncontrado = usuarioBuscado.get();
			BeanUtils.copyProperties(usuario, usuarioEncontrado, "id");
			return usuarioRepository.save(usuarioEncontrado);
		}
		return usuarioEncontrado;
	}

	public void delete(Long id) {
		Optional<Usuario> usuarioEncontrado = getUsuarioPorId(id);
		if (!usuarioEncontrado.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		usuarioEncontrado.get().setAtivo(false);
		usuarioRepository.delete(usuarioEncontrado.get());
	}

	public Usuario atualizarStatus(Long id, boolean ativo) {
		Optional<Usuario> usuarioEncontrado = getUsuarioPorId(id);
		if (usuarioEncontrado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		Usuario usuario = usuarioEncontrado.get();
		usuario.setAtivo(ativo);
		usuario = usuarioRepository.save(usuario);
		return usuario;

	}

}