package com.example.celestialobjectservice.service;

import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.repository.CelestialObjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelestialObjectService {

    private final CelestialObjectRepository celestialObjectRepository;

    public CelestialObjectService(CelestialObjectRepository celestialObjectRepository) {
        this.celestialObjectRepository = celestialObjectRepository;
    }

    public List<CelestialObject> getAllCelestialObject(){

    }
}
