package com.example.VentaCar.repository;

import com.example.VentaCar.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {
}
