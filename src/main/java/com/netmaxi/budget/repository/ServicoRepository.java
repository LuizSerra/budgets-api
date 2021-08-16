package com.netmaxi.budget.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.netmaxi.budget.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	
	Page<Servico> findByNome(String search, Pageable pagination);

}
