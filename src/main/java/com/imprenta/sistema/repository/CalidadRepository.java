package com.imprenta.sistema.repository;

import com.imprenta.sistema.model.Calidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalidadRepository extends JpaRepository<Calidad, Long> {
    Calidad findByNombre(String nombre);
}