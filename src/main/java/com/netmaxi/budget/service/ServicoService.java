package com.netmaxi.budget.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Servico;
import com.netmaxi.budget.repository.ServicoRepository;

@Service
public class ServicoService {

	public ServicoRepository servicoRepository;

	public Page<Servico> listar(String search, Pageable pagination) {
		if (search == null)
			return servicoRepository.findAll(pagination);
		return servicoRepository.findByNome(search, pagination);
	}

	public Optional<Servico> getServicoPorId(Long id) {
		return servicoRepository.findById(id);
	}

	public Servico criar(Servico servico) {
		return servicoRepository.save(servico);
	}

	public Servico atualizar(Long id, Servico servico) {
		Optional<Servico> servicoBuscado = getServicoPorId(id);
		Servico servicoEncontrado = null;
		if (servicoBuscado.isPresent()) {
			servicoEncontrado = servicoBuscado.get();
			BeanUtils.copyProperties(servico, servicoEncontrado, "id");
			return servicoRepository.save(servicoEncontrado);
		}
		return servicoEncontrado;
	}

	public void delete(Servico servico) {
		servicoRepository.delete(servico);
	}

}
