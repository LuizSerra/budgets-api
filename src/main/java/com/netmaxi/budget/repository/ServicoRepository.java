package com.netmaxi.budget.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.netmaxi.budget.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	
	/* Listar todos com nome que contenham o texto buscado */
	Page<Servico> findByNomeContaining(String search, Pageable pagination);

	/*buscar apenas filtrando por status ativo falso ou true*/
	Page<Servico> findByAtivoTrue(Pageable page);
	Page<Servico> findByAtivoFalse(Pageable page);
	/*busca que combina o status e o nome contendo texto*/
	Page<Servico> findByNomeContainingAndAtivoTrue(String search, Pageable pagination);
	Page<Servico> findByNomeContainingAndAtivoFalse(String search, Pageable pagination);

}
