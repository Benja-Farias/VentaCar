package com.example.VentaCar.service;

import com.example.VentaCar.model.Autos;
import com.example.VentaCar.repository.AutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutosService {

    @Autowired
    private AutosRepository autosRepository;

    public List<Autos> getAutos() {
        return autosRepository.findAll();
    }
}