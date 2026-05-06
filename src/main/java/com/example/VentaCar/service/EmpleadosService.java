package com.example.VentaCar.service;

import com.example.VentaCar.model.Clientes;
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

    public Empleados getEmpleadosId(int id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    public Empleados saveEmpleados(Empleados empleados) {
        return empleadosRepository.save(empleados);
    }

    public Empleados updateEmpleados(Empleados empleados) {
        if (empleados.getId_emp() == null || !empleadosRepository.existsById(empleados.getId_emp())) {
            return null;
        }
        return empleadosRepository.save(empleados);
    }

    public void deleteEmpleados(int id) {
        empleadosRepository.deleteById(id);
    }
}