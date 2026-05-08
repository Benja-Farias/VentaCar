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

    public Clientes saveCliente(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    public Clientes getClientesId(int id) {
        return clientesRepository.findById(id).orElse(null);
    }

    public Clientes updateCliente(Clientes clientes) {
        if (clientes.getId_cliente() == null || !clientesRepository.existsById(clientes.getId_cliente())) {
            return null;
        }
        return clientesRepository.save(clientes);
    }

    public void deleteCliente(int id) {
        clientesRepository.deleteById(id);
    }
}