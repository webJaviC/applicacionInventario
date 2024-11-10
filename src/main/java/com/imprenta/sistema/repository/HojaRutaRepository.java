package com.imprenta.sistema.repository;

import com.imprenta.sistema.model.HojaRuta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HojaRutaRepository extends JpaRepository<HojaRuta, Long> {
    HojaRuta findByNroHojaRuta(String nroHojaRuta);
}