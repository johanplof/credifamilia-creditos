package com.credifamilia.creditos.repository;

import com.credifamilia.creditos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}