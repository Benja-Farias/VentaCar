package com.example.VentaCar.controller;

import com.example.VentaCar.model.Autos;
import com.example.VentaCar.service.AutosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autos")
public class AutosController {

    @Autowired
    private AutosService autosService;

    @GetMapping
    public ResponseEntity<List<Autos>> listarAutos() {
        return ResponseEntity.ok(autosService.getAutos());
    }
}