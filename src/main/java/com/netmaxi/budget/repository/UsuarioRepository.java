package com.netmaxi.budget.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.netmaxi.budget.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
	
	Page<Usuario> findByAtivoTrue(Pageable page);
	
    Optional<Usuario> findByEmail(String email);

}
