package com.imprenta.sistema.repository;

import com.imprenta.sistema.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Material findByCodigo(String codigo);
}