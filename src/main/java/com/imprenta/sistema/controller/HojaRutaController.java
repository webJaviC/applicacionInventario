package com.imprenta.sistema.controller;

import com.imprenta.sistema.model.HojaRuta;
import com.imprenta.sistema.service.HojaRutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hojas-ruta")
public class HojaRutaController {
    
    @Autowired
    private HojaRutaService hojaRutaService;
    
    @GetMapping("/nueva")
    public String nuevaHojaRuta(Model model) {
        model.addAttribute("hojaRuta", new HojaRuta());
        return "hojas-ruta/form";
    }
    
    @PostMapping("/guardar")
    public String guardarHojaRuta(@ModelAttribute HojaRuta hojaRuta) {
        hojaRutaService.crearHojaRuta(hojaRuta);
        return "redirect:/hojas-ruta/lista";
    }
    
    @GetMapping("/lista")
    public String listarHojasRuta(Model model) {
        model.addAttribute("hojasRuta", hojaRutaService.listarTodas());
        return "hojas-ruta/lista";
    }
}