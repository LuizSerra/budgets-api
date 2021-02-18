package com.netmaxi.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netmaxi.budget.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
