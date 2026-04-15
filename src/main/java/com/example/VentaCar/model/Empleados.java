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
@Table(name = "empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_emp;

    @NotBlank
    private Integer run;

    @NotBlank
    private String nombre;

    @NotBlank
    private Date fecha_nacimiento;

    @NotBlank
    private Date fecha_contrato;

    @NotNull
    private Integer sueldo_base;
}
