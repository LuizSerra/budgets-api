package com.netmaxi.budget.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Usuario;
import com.netmaxi.budget.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Page<Usuario> listar(String search, Boolean ativo, Pageable pagination) {

		if (search == null)
			return ativo == null ? usuarioRepository.findAll(pagination)
					: ativo ? usuarioRepository.findByAtivoTrue(pagination)
							: usuarioRepository.findByAtivoFalse(pagination);

		return ativo == null ? usuarioRepository.findByNomeContaining(search, pagination)
				: ativo ? usuarioRepository.findByNomeContainingAndAtivoTrue(search, pagination)
						: usuarioRepository.findByNomeContainingAndAtivoFalse(search, pagination);
	}

	public Optional<Usuario> getUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario criar(Usuario usuario) {
		usuario.setAtivo(true);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
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

	public ResponseEntity<?> delete(Long id) {
		Optional<Usuario> usuarioBuscado = getUsuarioPorId(id);
		if(usuarioBuscado.isPresent()) {
			Usuario usuarioEncontrado = usuarioBuscado.get();
			usuarioEncontrado.setAtivo(false);
			usuarioRepository.save(usuarioEncontrado);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado"); 
	}

	public Usuario atualizarStatus(Long id, boolean ativo) {
		Optional<Usuario> usuarioEncontrado = getUsuarioPorId(id);
		if (!usuarioEncontrado.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		Usuario usuario = usuarioEncontrado.get();
		usuario.setAtivo(ativo);
		usuario = usuarioRepository.save(usuario);
		return usuario;

	}

	public Page<Usuario> listarUsuarioPorPapelId(Long idPapel, Pageable pagination) {
		return usuarioRepository.findByPapeis_Id(idPapel, pagination);
	}

}