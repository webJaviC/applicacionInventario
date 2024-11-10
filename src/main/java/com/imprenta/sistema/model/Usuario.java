package com.imprenta.sistema.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    
    private boolean activo = true;
}

enum TipoUsuario {
    ADMIN,
    PRODUCCION,
    ALMACENES
}