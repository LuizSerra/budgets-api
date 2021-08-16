package com.netmaxi.budget.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.netmaxi.budget.model.Papel;

public interface PapelRepository extends PagingAndSortingRepository<Papel, Long> {
	
	Page<Papel> findByNome(String search, Pageable pagination);

}
