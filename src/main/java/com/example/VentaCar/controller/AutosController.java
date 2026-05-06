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

    @GetMapping("/{id}")
    public ResponseEntity<Autos> buscarAutos(@PathVariable int id) {
        Autos autos = autosService.getAutosId(id);
        return autos != null ? ResponseEntity.ok(autos) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Autos> agregarAutos(@Valid @RequestBody Autos autos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autosService.saveAutos(autos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autos> actualizarAutos(@PathVariable int id, @Valid @RequestBody Autos autos) {
        autos.setId_auto(id); 
        Autos actualizado = autosService.updateAutos(autos);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutos(@PathVariable int id) {
        autosService.deleteAutos(id);
        return ResponseEntity.noContent().build();
    }
}