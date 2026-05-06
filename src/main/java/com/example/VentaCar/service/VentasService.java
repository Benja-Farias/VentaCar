package com.example.VentaCar.service;

import com.example.VentaCar.dto.VentasAutosDTO;
import com.example.VentaCar.model.Empleados;
import com.example.VentaCar.model.Ventas;
import com.example.VentaCar.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    public List<Ventas> getVentas() {
        return ventasRepository.findAll();
    }

    public List<VentasAutosDTO> getVentasConDetalles() {
        return ventasRepository.findAll().stream()
                .map(v -> new VentasAutosDTO(
                        v.getAutos().getModelo(),
                        v.getAutos().getMarca(),
                        v.getClientes().getNombre_cliente(),
                        v.getEmpleados().getNombre_empleado(),
                        v.getFecha_venta(),
                        v.getTotal_venta()
                ))
                .toList();
    }
    
    public Ventas getVentasId(int id) {
        return ventasRepository.findById(id).orElse(null);
    }

    public Ventas saveVentas(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    public Ventas updateVentas(Ventas ventas) {
        if (ventas.getId_venta() == null || !ventasRepository.existsById(ventas.getId_venta())) {
            return null;
        }
        return ventasRepository.save(ventas);
    }

    public void deleteVentas(int id) {
        ventasRepository.deleteById(id);
    }
}

