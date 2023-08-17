package com.example.celestialobjectservice.service;


import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.repository.CelestialObjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CelestialObjectServiceTest {
    @Mock
    CelestialObjectRepository celestialObjectRepository;
    @InjectMocks
    CelestialObjectService celestialObjectService;

    @Test
    void testCreateCelestialObject(){


        CelestialObject celestialObject = new CelestialObject(0,"test");
        Mockito.when(celestialObjectRepository.save(celestialObject)).thenReturn(celestialObject);

        CelestialObject result = celestialObjectService.createCelestialObject("test");

        Assertions.assertEquals(celestialObject, result);
    }
    @Test
    void testGetAllCelestialObject(){

        List<CelestialObject> celestialObjects = new ArrayList<>();
        CelestialObject celestialObject = new CelestialObject(0,"test");
        CelestialObject celestialObject1 = new CelestialObject(1,"test1");
        celestialObjects.add(celestialObject);
        celestialObjects.add(celestialObject1);
        Mockito.when(celestialObjectRepository.findAll()).thenReturn(celestialObjects);

        List<CelestialObject> result = celestialObjectService.getAllCelestialObject();

        Assertions.assertEquals(celestialObjects, result);

    }

    @Test
    void testGetCelestialObjectById(){
        CelestialObject celestialObject = new CelestialObject(0,"test");
        Mockito.when(celestialObjectRepository.findById(0)).thenReturn(Optional.of(celestialObject));

        CelestialObject result = celestialObjectService.getCelestialObjectById(0);

        Assertions.assertEquals(celestialObject, result);

    }
}
