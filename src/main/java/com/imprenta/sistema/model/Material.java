package com.imprenta.sistema.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "materiales")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigo;
    private Double gramaje;
    private Double kilosBruto;
    private Double kilosNeto;
    private Double ancho;
    private Double largo;
    
    @ManyToOne
    private Calidad calidad;
}