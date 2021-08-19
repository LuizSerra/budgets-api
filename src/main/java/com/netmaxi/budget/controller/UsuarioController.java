package com.netmaxi.budget.controller;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netmaxi.budget.controller.dto.UsuarioDTO;
import com.netmaxi.budget.model.Usuario;
import com.netmaxi.budget.repository.UsuarioRepository;
import com.netmaxi.budget.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
    UsuarioRepository usuarioRepository;
	
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> listar(String search, Boolean ativo, Pageable pagination) {
		Page<UsuarioDTO> usuarios = UsuarioDTO.convertToUsuarioDTOList(usuarioService.listar(search, ativo, pagination));
        return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuarioPorId(@PathVariable Long id) {
		Optional<Usuario> usuarioEncontrado = usuarioService.getUsuarioPorId(id);
		return usuarioEncontrado.isPresent() ? ResponseEntity.ok(new UsuarioDTO(usuarioEncontrado.get())) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");  
	}
	
	@GetMapping("/papel/{idPapel}")
	public ResponseEntity<Page<UsuarioDTO>> listarUsuarioPorPapelId(@PathVariable Long idPapel, Pageable pagination) {
		Page<UsuarioDTO> usuarios = UsuarioDTO.convertToUsuarioDTOList(usuarioService.listarUsuarioPorPapelId(idPapel, pagination));
        return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build(); 
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioCriado = usuarioService.criar(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(usuarioCriado.getId()).toUri();
		return ResponseEntity.created(uri).body(usuarioCriado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(usuarioAtualizado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(usuarioAtualizado);
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Usuario> atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody boolean ativo){
		Usuario usuarioAtualizado =	usuarioService.atualizarStatus(id, ativo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(usuarioAtualizado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(usuarioAtualizado);
	}
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
		usuarioService.delete(id);
	}
}
