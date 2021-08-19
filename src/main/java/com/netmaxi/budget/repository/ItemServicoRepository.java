package com.netmaxi.budget.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.netmaxi.budget.model.ItemServico;
import com.netmaxi.budget.model.ItemServico.Id;

public interface ItemServicoRepository extends PagingAndSortingRepository<ItemServico, Id>{
	
	Page<ItemServico> findByOrcamento_Id(Long idOrcamento, Pageable pagination);
	Page<ItemServico> findByServico_Id(Long idServico, Pageable pagination);
	
}
