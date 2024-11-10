package com.imprenta.sistema.service;

import com.imprenta.sistema.model.Material;
import com.imprenta.sistema.model.HojaRuta;
import com.imprenta.sistema.repository.MaterialRepository;
import com.imprenta.sistema.repository.HojaRutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MaterialService {
    
    @Autowired
    private MaterialRepository materialRepository;
    
    @Autowired
    private HojaRutaRepository hojaRutaRepository;
    
    public Material guardarMaterial(Material material) {
        return materialRepository.save(material);
    }
    
    public List<Material> listarTodos() {
        return materialRepository.findAll();
    }
    
    public Material buscarPorCodigo(String codigo) {
        return materialRepository.findByCodigo(codigo);
    }
    
    @Transactional
    public void asignarMaterialAHojaRuta(String codigoMaterial, String nroHojaRuta, int ordenProduccion) {
        Material material = buscarPorCodigo(codigoMaterial);
        HojaRuta hojaRuta = hojaRutaRepository.findByNroHojaRuta(nroHojaRuta);
        
        if (material != null && hojaRuta != null) {
            // Aquí se implementaría la lógica de asignación
            // Por ejemplo, crear una nueva entidad AsignacionMaterial
        }
    }
    
    public void actualizarKilosNetos(String codigo, Double nuevosKilosNetos) {
        Material material = buscarPorCodigo(codigo);
        if (material != null) {
            material.setKilosNeto(nuevosKilosNetos);
            materialRepository.save(material);
        }
    }
}