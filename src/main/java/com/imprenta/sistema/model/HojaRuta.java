package com.imprenta.sistema.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "hojas_ruta")
public class HojaRuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nroHojaRuta;
    private String nroCliente;
    private String nroProducto;
    private String descripcion;
    private Double gramaje;
    private Double kilosNecesarios;
    private Double largo;
    private Double ancho;
    private LocalDate fecha;
    
    @Enumerated(EnumType.STRING)
    private EstadoHR estado;
}

enum EstadoHR {
    ALTA,
    CERRADO
}