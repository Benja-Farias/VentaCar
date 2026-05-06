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

    public Autos saveAutos(Autos autos) {
        return autosRepository.save(autos);
    }

    public Autos getAutosId(int id) {
        return autosRepository.findById(id).orElse(null);
    }

    public Autos updateAutos(Autos autos) {
        if (autos.getId_auto() == null || !autosRepository.existsById(autos.getId_auto())) {
            return null;
        }
        return autosRepository.save(autos);
    }

    public void deleteAutos(int id) {
        autosRepository.deleteById(id);
    }
}