package com.example.VentaCar.model;

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
    private String nombre_empleado;

    @NotNull
    private Integer telefono;

    @NotBlank
    private String email;
}
