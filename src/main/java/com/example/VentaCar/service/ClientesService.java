package com.example.VentaCar.service;

import com.example.VentaCar.model.Clientes;
import com.example.VentaCar.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> getClientes() {
        return clientesRepository.findAll();
    }
}