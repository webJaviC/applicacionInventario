package com.imprenta.sistema.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "remitos")
public class Remito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nroRemito;
    private LocalDate fecha;
    private String proveedor;
    
    @OneToMany
    private List<Material> materiales;
}