package com.example.VentaCar.controller;

import com.example.VentaCar.model.Empleados;
import com.example.VentaCar.service.EmpleadosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;

    @GetMapping
    public ResponseEntity<List<Empleados>> listarEmpleados() {
        return ResponseEntity.ok(empleadosService.getEmpleados());
    }
}