package com.example.VentaCar.model;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;

    @NotBlank
    @OneToOne()
    private Clientes clientes;

    @NotBlank
    @OneToOne()
    private Empleados empleados;

    @NotBlank
    @OneToOne()
    private Autos autos;

    @NotBlank
    private Date fecha;

    @NotBlank
    private Integer Total_venta;
}
