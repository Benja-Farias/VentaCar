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

    @GetMapping("/{id}")
    public ResponseEntity<Empleados> buscarEmpleados(@PathVariable int id) {
        System.out.println("[EmpleadosController] -> buscarEmpleados id=" + id);
        Empleados empleados = empleadosService.getEmpleadosId(id);
        if (empleados == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @PostMapping
    public ResponseEntity<Empleados> agregarEmpleados(@Valid @RequestBody Empleados empleados) {
        System.out.println("[EmpleadosController] -> agregarEmpleados");
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadosService.saveEmpleados(empleados));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleados> actualizarEmpleados(@PathVariable int id, @Valid @RequestBody Empleados empleados) {
        System.out.println("[EmpleadosController] -> actualizarEmpleados id=" + id);
        empleados.setId_emp(id);
        Empleados actualizado = empleadosService.updateEmpleados(empleados);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleados(@PathVariable int id) {
        System.out.println("[EmpleadosController] -> eliminarEmpleados id=" + id);
        empleadosService.deleteEmpleados(id);
        return ResponseEntity.noContent().build();
    }
}