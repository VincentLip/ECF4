package com.example.celestialobjectservice.service;


import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.repository.CelestialObjectRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CelestialObjectServiceTest {
    @Mock
    CelestialObjectRepository celestialObjectRepository;
    @InjectMocks
    CelestialObjectService celestialObjectService;

    @Test
    @Order(1)
    void testCreateCelestialObject(){
        CelestialObject celestialObject = celestialObjectService.createCelestialObject("test");

        assertThat(celestialObject.getId()).isNotNull();
    }
    @Test
    @Order(2)
    void testGetAllCelestialObject(){
        celestialObjectService.createCelestialObject("test");
        List<CelestialObject> celestialObjects = celestialObjectService.getAllCelestialObject();
        assertThat(celestialObjects.size()).isGreaterThan(0);

    }
}
