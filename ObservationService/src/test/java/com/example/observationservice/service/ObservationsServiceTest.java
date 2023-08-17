package com.example.observationservice.service;

import com.example.observationservice.entity.Observations;
import com.example.observationservice.repository.ObservationsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ObservationsServiceTest {
    @Mock
    ObservationsRepository observationsRepository;
    @InjectMocks
    ObservationsService observationsService;

    @Test
    void testCreateObservations(){
       Observations observations = observationsService.createObservations(1,1,"test",new Date(),"http://test");
        assertThat(observations.getId()).isEqualTo(0);
    }

}
