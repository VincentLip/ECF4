package com.example.celestialobjectservice.service;

import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.repository.CelestialObjectRepository;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CelestialObjectService {

    private final CelestialObjectRepository celestialObjectRepository;

    public CelestialObjectService(CelestialObjectRepository celestialObjectRepository) {
        this.celestialObjectRepository = celestialObjectRepository;
    }
    public CelestialObject createCelestialObject(String name) {
        CelestialObject celestialObject = CelestialObject.builder().name(name).build();
        celestialObjectRepository.save(celestialObject);
        return celestialObject;
    }

    public List<CelestialObject> getAllCelestialObject(){
        return (List<CelestialObject>) celestialObjectRepository.findAll();
    }

    public CelestialObject getCelestialObjectById(int id) {
        Optional<CelestialObject> celestialObjectOptional = celestialObjectRepository.findById(id);
        if(celestialObjectOptional.isPresent()) {
            return celestialObjectOptional.get();
        }
        throw new RuntimeException("Not found");
    }
}
