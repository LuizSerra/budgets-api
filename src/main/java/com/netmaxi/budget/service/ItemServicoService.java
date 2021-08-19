package com.netmaxi.budget.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.ItemServico;
import com.netmaxi.budget.model.ItemServico.Id;
import com.netmaxi.budget.repository.ItemServicoRepository;

@Service
public class ItemServicoService {

	@Autowired
	ItemServicoRepository itemServicoRepository;

	public Page<ItemServico> listar(Pageable pagination) {
		return itemServicoRepository.findAll(pagination);
	}

	public Optional<ItemServico> getItemServicoPorIds(Long servId, Long orcamId) {
		Id id = new Id(servId, orcamId);
		return itemServicoRepository.findById(id);
	}

	public Page<ItemServico> listarPorServicoId(Long idServico, Pageable pagination) {
		return itemServicoRepository.findByServico_Id(idServico, pagination);
	}
	
	public Page<ItemServico> listarPorOrcamentoId(Long idOrcamento, Pageable pagination) {
		return itemServicoRepository.findByOrcamento_Id(idOrcamento, pagination);
	}
	
	public ItemServico criar(ItemServico itemServico) {
		return itemServicoRepository.save(itemServico);
	}

	public ItemServico atualizar(Long servId, Long orcamId, ItemServico itemServico) {
		Optional<ItemServico> itemServicoBuscado = getItemServicoPorIds(servId, orcamId);
		ItemServico itemServicoEncontrado = null;
		if (itemServicoBuscado.isPresent()) {
			itemServicoEncontrado = itemServicoBuscado.get();
			BeanUtils.copyProperties(itemServico, itemServicoEncontrado,  "valorTotal", "id");
			return itemServicoRepository.save(itemServicoEncontrado);
		}
		return itemServicoEncontrado;
	}

	public ResponseEntity<?> delete(Long servId, Long orcamId) {
		Optional<ItemServico> itemServicoBuscado = getItemServicoPorIds(servId, orcamId);
		if(itemServicoBuscado.isPresent()) {
			ItemServico itemServicoEncontrado = itemServicoBuscado.get();
			itemServicoRepository.delete(itemServicoEncontrado);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado"); 
	}

}