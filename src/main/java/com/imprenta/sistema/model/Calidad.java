package com.imprenta.sistema.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "calidades")
public class Calidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String descripcion;
}