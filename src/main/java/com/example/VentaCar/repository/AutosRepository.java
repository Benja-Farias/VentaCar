package com.example.VentaCar.repository;

import com.example.VentaCar.model.Autos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutosRepository extends JpaRepository<Autos, Integer> {
}
