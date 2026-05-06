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
@Table(name = "autos")
public class Autos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_auto;

    @NotBlank
    private String patente;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String año;

    @NotNull
    private Integer precio;

    @NotNull
    private Integer kilometraje;

    @NotNull
    private String estado;
}
