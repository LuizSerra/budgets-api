package com.netmaxi.budget.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Papel;
import com.netmaxi.budget.repository.PapelRepository;

@Service
public class PapelService {

	@Autowired
	PapelRepository papelRepository;

	public Page<Papel> listar(String search, Pageable pagination) {

		if (search == null)
			return papelRepository.findAll(pagination);
		return papelRepository.findByNome(search, pagination);
	}

	public Optional<Papel> getPapelPorId(Long id) {
		return papelRepository.findById(id);
	}
}
