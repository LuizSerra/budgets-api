package com.netmaxi.budget.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.netmaxi.budget.model.Orcamento;

public interface OrcamentoRepository extends PagingAndSortingRepository<Orcamento, Long> {
	
    /* Listar todos com nome que contenham o texto buscado */
	Page<Orcamento> findByNomeContaining(String search, Pageable pagination);

	/*buscar apenas filtrando por status ativo falso ou true*/
	Page<Orcamento> findByAtivoTrue(Pageable page);
	Page<Orcamento> findByAtivoFalse(Pageable page);
	/*busca que combina o status e o nome contendo texto*/
	Page<Orcamento> findByNomeContainingAndAtivoTrue(String search, Pageable pagination);
	Page<Orcamento> findByNomeContainingAndAtivoFalse(String search, Pageable pagination);
	
	/*busca usuarios pelo id do usuario*/
	Page<Orcamento> findByUsuario_Id(Long idUsuario, Pageable pagination);
	
	//TODO Implementar QueryMethods para as datas

}
