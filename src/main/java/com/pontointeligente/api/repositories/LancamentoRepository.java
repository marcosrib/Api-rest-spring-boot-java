package com.pontointeligente.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.pontointeligente.api.entity.Lancamento;

@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	@Transactional(readOnly = true)
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

	@Transactional(readOnly = true)
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);

	//Lancamento findOne(Long id);

}