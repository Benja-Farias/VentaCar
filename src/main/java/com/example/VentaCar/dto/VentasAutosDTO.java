package com.example.VentaCar.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentasAutosDTO {

    private String modelo;
    private String marca;
    private String nombre_cliente;
    private String nombre_empleado;
    private Date fecha_venta;
    private Integer Total_venta;
}