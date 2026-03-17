package com.credifamilia.creditos.repository;

import com.credifamilia.creditos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}