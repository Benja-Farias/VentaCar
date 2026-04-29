package com.example.VentaCar.service;

import com.example.VentaCar.model.Empleados;
import com.example.VentaCar.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosService {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    public List<Empleados> getEmpleados() {
        return empleadosRepository.findAll();
    }
}