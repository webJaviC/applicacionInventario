package com.imprenta.sistema.service;

import com.imprenta.sistema.model.Remito;
import com.imprenta.sistema.model.Material;
import com.imprenta.sistema.repository.RemitoRepository;
import com.imprenta.sistema.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RemitoService {
    
    @Autowired
    private RemitoRepository remitoRepository;
    
    @Autowired
    private MaterialRepository materialRepository;
    
    @Transactional
    public Remito crearRemito(Remito remito) {
        remito.setFecha(LocalDate.now());
        List<Material> materiales = new ArrayList<>();
        if (remito.getMateriales() != null) {
            for (Material material : remito.getMateriales()) {
                Material savedMaterial = materialRepository.save(material);
                materiales.add(savedMaterial);
            }
        }
        remito.setMateriales(materiales);
        return remitoRepository.save(remito);
    }
    
    public List<Remito> listarTodos() {
        return remitoRepository.findAll();
    }
    
    public Remito buscarPorNumero(String nroRemito) {
        return remitoRepository.findByNroRemito(nroRemito);
    }
    
    @Transactional
    public Remito procesarArchivoRemito(String rutaArchivo) throws IOException {
        Remito remito = new Remito();
        List<Material> materiales = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            boolean firstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    // Primera línea contiene información del remito
                    String[] remitoData = line.split(",");
                    remito.setNroRemito(remitoData[0]);
                    remito.setProveedor(remitoData[1]);
                    firstLine = false;
                } else {
                    // Resto de líneas contienen materiales
                    String[] materialData = line.split(",");
                    Material material = new Material();
                    material.setCodigo(materialData[0]);
                    material.setGramaje(Double.parseDouble(materialData[1]));
                    material.setKilosBruto(Double.parseDouble(materialData[2]));
                    material.setKilosNeto(Double.parseDouble(materialData[3]));
                    material.setAncho(Double.parseDouble(materialData[4]));
                    material.setLargo(Double.parseDouble(materialData[5]));
                    materiales.add(material);
                }
            }
        }
        
        remito.setMateriales(materiales);
        return crearRemito(remito);
    }
}