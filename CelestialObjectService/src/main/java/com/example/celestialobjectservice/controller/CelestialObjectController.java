package com.example.celestialobjectservice.controller;

import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.service.CelestialObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/celest")
public class CelestialObjectController {

    private final CelestialObjectService celestialObjectService;


    public CelestialObjectController(CelestialObjectService celestialObjectService) {
        this.celestialObjectService = celestialObjectService;
    }

    @GetMapping("")
    public ResponseEntity<List<CelestialObject>> getAll() {
        List<CelestialObject> celestialObjects = celestialObjectService.getAllCelestialObject();
        return ResponseEntity.ok(celestialObjects);
    }
    @PostMapping("")
    public ResponseEntity<CelestialObject> post(@RequestParam String name) {
        CelestialObject celestialObject = celestialObjectService.createCelestialObject(name);
        return ResponseEntity.ok(celestialObject);
    }

    @GetMapping("{id}")
    public ResponseEntity<CelestialObject> get(@PathVariable int id) {
        CelestialObject celestialObject = celestialObjectService.getCelestialObjectById(id);
        return ResponseEntity.ok(celestialObject);
    }


}
