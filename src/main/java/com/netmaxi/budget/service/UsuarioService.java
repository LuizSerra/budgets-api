package com.netmaxi.budget.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Usuario;
import com.netmaxi.budget.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsers(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Usuario> pagedResult = usuarioRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Usuario>();
		}
	}

	public List<Usuario> getAllUsersActive(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Usuario> pagedResult = usuarioRepository.findByAtivoTrue(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Usuario>();
		}
	}

	public Usuario create(Usuario usuario) {
		usuario.setAtivo(true);
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Long id, Usuario usuario) {
		Usuario usuarioEncontrado = findById(id);

		BeanUtils.copyProperties(usuario, usuarioEncontrado, "id");
		return usuarioRepository.save(usuarioEncontrado);
	}

	public void delete(Long id) {
		Usuario usuarioEncontrado = findById(id);
		if (usuarioEncontrado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		usuarioRepository.delete(usuarioEncontrado);
	}

	public Usuario updateStatus(Long id, boolean ativo) {
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
		if (usuarioEncontrado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		Usuario usuario = usuarioEncontrado.get();
		usuario.setAtivo(ativo);
		usuario = usuarioRepository.save(usuario);
		return usuario;

	}

	public Usuario findById(Long id) {
		Optional<Usuario> usuarioAtualizado = usuarioRepository.findById(id);
		if (usuarioAtualizado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioAtualizado.get();
	}




}