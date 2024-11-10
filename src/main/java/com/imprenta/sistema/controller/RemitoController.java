package com.imprenta.sistema.controller;

import com.imprenta.sistema.model.Remito;
import com.imprenta.sistema.service.RemitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/remitos")
public class RemitoController {
    
    @Autowired
    private RemitoService remitoService;
    
    @GetMapping
    public String listarRemitos(Model model) {
        model.addAttribute("remitos", remitoService.listarTodos());
        return "remitos/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevoRemito(Model model) {
        model.addAttribute("remito", new Remito());
        return "remitos/form";
    }
    
    @PostMapping("/guardar")
    public String guardarRemito(@ModelAttribute Remito remito) {
        remitoService.crearRemito(remito);
        return "redirect:/remitos";
    }
    
    @PostMapping("/cargar-archivo")
    public String cargarArchivoRemito(@RequestParam("archivo") MultipartFile archivo) {
        try {
            Path tempFile = Files.createTempFile("remito", ".txt");
            Files.copy(archivo.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
            remitoService.procesarArchivoRemito(tempFile.toString());
            Files.delete(tempFile);
            return "redirect:/remitos";
        } catch (Exception e) {
            return "redirect:/remitos?error";
        }
    }
}