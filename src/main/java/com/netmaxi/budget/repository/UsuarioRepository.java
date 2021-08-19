package com.netmaxi.budget.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.netmaxi.budget.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
	
    Optional<Usuario> findByEmail(String email);
    
    /* Listar todos com nome que contenham o texto buscado */
	Page<Usuario> findByNomeContaining(String search, Pageable pagination);

	/*buscar apenas filtrando por status ativo falso ou true*/
	Page<Usuario> findByAtivoTrue(Pageable page);
	Page<Usuario> findByAtivoFalse(Pageable page);
	/*busca que combina o status e o nome contendo texto*/
	Page<Usuario> findByNomeContainingAndAtivoTrue(String search, Pageable pagination);
	Page<Usuario> findByNomeContainingAndAtivoFalse(String search, Pageable pagination);
	
	/*busca usuarios pelo id do papel*/
	Page<Usuario> findByPapeis_Id(Long idPapel, Pageable pagination);

}
