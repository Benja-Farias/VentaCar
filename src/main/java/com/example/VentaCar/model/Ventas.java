package com.example.VentaCar.model;

import java.sql.Date;

import jakarta.persistence.*;
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

    @NotNull 
    @ManyToOne
    @JoinColumn(name = "clientes_id_cliente")
    private Clientes clientes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "empleados_id_emp")
    private Empleados empleados;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "autos_id_auto")
    private Autos autos;

    @NotNull
    private Date fecha_venta;

    @NotNull
    private Integer Total_venta;
}
