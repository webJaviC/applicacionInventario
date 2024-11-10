package com.imprenta.sistema.service;

import com.imprenta.sistema.model.HojaRuta;
import com.imprenta.sistema.model.EstadoHR;
import com.imprenta.sistema.repository.HojaRutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HojaRutaService {
    
    @Autowired
    private HojaRutaRepository hojaRutaRepository;
    
    public HojaRuta crearHojaRuta(HojaRuta hojaRuta) {
        hojaRuta.setFecha(LocalDate.now());
        hojaRuta.setEstado(EstadoHR.ALTA);
        return hojaRutaRepository.save(hojaRuta);
    }
    
    public HojaRuta buscarPorNumero(String nroHojaRuta) {
        return hojaRutaRepository.findByNroHojaRuta(nroHojaRuta);
    }
    
    public void cerrarHojaRuta(String nroHojaRuta) {
        HojaRuta hr = buscarPorNumero(nroHojaRuta);
        hr.setEstado(EstadoHR.CERRADO);
        hojaRutaRepository.save(hr);
    }
}