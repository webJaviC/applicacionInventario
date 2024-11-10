package com.imprenta.sistema.controller;

import com.imprenta.sistema.model.Material;
import com.imprenta.sistema.service.MaterialService;
import com.imprenta.sistema.service.CalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materiales")
public class MaterialController {
    
    @Autowired
    private MaterialService materialService;
    
    @Autowired
    private CalidadService calidadService;
    
    @GetMapping
    public String listarMateriales(Model model) {
        model.addAttribute("materiales", materialService.listarTodos());
        return "materiales/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevoMaterial(Model model) {
        model.addAttribute("material", new Material());
        model.addAttribute("calidades", calidadService.listarTodas());
        return "materiales/form";
    }
    
    @PostMapping("/guardar")
    public String guardarMaterial(@ModelAttribute Material material) {
        materialService.guardarMaterial(material);
        return "redirect:/materiales";
    }
    
    @PostMapping("/asignar")
    public String asignarAHojaRuta(@RequestParam String codigoMaterial,
                                  @RequestParam String nroHojaRuta,
                                  @RequestParam int ordenProduccion) {
        materialService.asignarMaterialAHojaRuta(codigoMaterial, nroHojaRuta, ordenProduccion);
        return "redirect:/materiales";
    }
    
    @PostMapping("/actualizar-kilos")
    public String actualizarKilosNetos(@RequestParam String codigo,
                                      @RequestParam Double nuevosKilosNetos) {
        materialService.actualizarKilosNetos(codigo, nuevosKilosNetos);
        return "redirect:/materiales";
    }
}