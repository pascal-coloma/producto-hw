package com.hoppyware.productos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto", schema="PRODUCTOMS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador_secuencia_id_ped")
    @SequenceGenerator(name = "generador_secuencia_id_ped", sequenceName = "secuencia_id_ped", allocationSize = 1)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String proveedor;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Integer stock;
}
