package com.imprenta.sistema.repository;

import com.imprenta.sistema.model.Remito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemitoRepository extends JpaRepository<Remito, Long> {
    Remito findByNroRemito(String nroRemito);
}