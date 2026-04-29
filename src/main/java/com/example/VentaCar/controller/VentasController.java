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
}