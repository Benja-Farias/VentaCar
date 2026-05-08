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
        System.out.println("[ClientesController] -> listarClientes");
        return ResponseEntity.ok(clientesService.getClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> buscarClientes(@PathVariable int id) {
        System.out.println("[ClientesController] -> buscarClientes id=" + id);
        Clientes cliente = clientesService.getClientesId(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Clientes> agregarCliente(@Valid @RequestBody Clientes clientes) {
        System.out.println("[ClientesController] -> agregarCliente");
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.saveCliente(clientes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> actualizarCliente(@PathVariable int id, @Valid @RequestBody Clientes clientes) {
        System.out.println("[ClientesController] -> actualizarCliente id=" + id);
        clientes.setId_cliente(id);
        Clientes actualizado = clientesService.updateCliente(clientes);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable int id) {
        System.out.println("[ClientesController] -> eliminarCliente id=" + id);
        clientesService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}