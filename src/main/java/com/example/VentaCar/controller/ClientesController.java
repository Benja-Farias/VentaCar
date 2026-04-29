package com.example.VentaCar.controller;

import com.example.VentaCar.model.Clientes;
import com.example.VentaCar.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<Clientes>> listarClientes() {
        return ResponseEntity.ok(clientesService.getClientes());
    }
}