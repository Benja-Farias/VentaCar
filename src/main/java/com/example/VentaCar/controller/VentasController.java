package com.example.VentaCar.controller;

import com.example.VentaCar.dto.VentasAutosDTO;
import com.example.VentaCar.model.Ventas;
import com.example.VentaCar.service.VentasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping
    public ResponseEntity<List<Ventas>> listarVentas() {
        return ResponseEntity.ok(ventasService.getVentas());
    }

    @GetMapping("/con-ventas")
    public ResponseEntity<List<VentasAutosDTO>> VentasDetalladas() {
        return ResponseEntity.ok(ventasService.getVentasConDetalles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> buscarVentas(@PathVariable int id) {
        System.out.println("[VentasController] -> buscarVentas id=" + id);
        Ventas ventas = ventasService.getVentasId(id);
        if (ventas == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<Ventas> agregarVentas(@Valid @RequestBody Ventas ventas) {
        System.out.println("[VentasController] -> agregarVentas");
        return ResponseEntity.status(HttpStatus.CREATED).body(ventasService.saveVentas(ventas));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> actualizarVentas(@PathVariable int id, @Valid @RequestBody Ventas ventas) {
        System.out.println("[VentasController] -> actualizarVentas id=" + id);
        ventas.setId_venta(id);
        Ventas actualizado = ventasService.updateVentas(ventas);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVentas(@PathVariable int id) {
        System.out.println("[VentasController] -> eliminarVentas id=" + id);
        ventasService.deleteVentas(id);
        return ResponseEntity.noContent().build();
    }
}