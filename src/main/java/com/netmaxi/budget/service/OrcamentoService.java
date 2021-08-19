package com.netmaxi.budget.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netmaxi.budget.model.Orcamento;
import com.netmaxi.budget.model.StatusOrcamento;
import com.netmaxi.budget.repository.OrcamentoRepository;

@Service
public class OrcamentoService {

	@Autowired
	OrcamentoRepository orcamentoRepository;

	public Page<Orcamento> listar(String search, Boolean ativo, Pageable pagination) {

		if (search == null)
			return ativo == null ? orcamentoRepository.findAll(pagination)
					: ativo ? orcamentoRepository.findByAtivoTrue(pagination)
							: orcamentoRepository.findByAtivoFalse(pagination);

		return ativo == null ? orcamentoRepository.findByNomeContaining(search, pagination)
				: ativo ? orcamentoRepository.findByNomeContainingAndAtivoTrue(search, pagination)
						: orcamentoRepository.findByNomeContainingAndAtivoFalse(search, pagination);
	}

	public Optional<Orcamento> getOrcamentoPorId(Long id) {
		return orcamentoRepository.findById(id);
	}

	public Orcamento criar(Orcamento orcamento) {
		orcamento.setAtivo(true);
		orcamento.setStatus(StatusOrcamento.NOVO);
		orcamento.setDataAbertura(LocalDate.now());
		return orcamentoRepository.save(orcamento);
	}

	public Orcamento atualizar(Long id, Orcamento orcamento) {
		Optional<Orcamento> orcamentoBuscado = getOrcamentoPorId(id);
		Orcamento orcamentoEncontrado = null;
		if (orcamentoBuscado.isPresent()) {
			orcamentoEncontrado = orcamentoBuscado.get();
			BeanUtils.copyProperties(orcamento, orcamentoEncontrado, "valorFinal", "id");
			return orcamentoRepository.save(orcamentoEncontrado);
		}
		return orcamentoEncontrado;
	}

	public Orcamento atualizarStatus(Long id, boolean ativo) {
		Optional<Orcamento> orcamentoEncontrado = getOrcamentoPorId(id);
		if (!orcamentoEncontrado.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		Orcamento orcamento = orcamentoEncontrado.get();
		orcamento.setAtivo(ativo);
		orcamento = orcamentoRepository.save(orcamento);
		return orcamento;

	}

	public void delete(Long id) {
		Optional<Orcamento> orcamentoEncontrado = getOrcamentoPorId(id);
		if (!orcamentoEncontrado.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		orcamentoEncontrado.get().setAtivo(false);
	}

	public Page<Orcamento> listarOrcamentoPorUsuarioId(Long id, Pageable pagination) {
		return orcamentoRepository.findByUsuario_Id(id, pagination);
	}

}
