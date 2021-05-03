package com.netmaxi.budget.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Papel;
import com.netmaxi.budget.repository.PapelRepository;

@Service
public class PapelService {

	@Autowired
	PapelRepository papelRepository;

	public List<Papel> getAllPermissons(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Papel> pagedResult = papelRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Papel>();
		}
	}
}
