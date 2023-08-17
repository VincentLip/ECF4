package com.example.observationservice.dto;

import com.example.observationservice.entity.Observations;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ObservationsResponseDTO {

    private List<Observations> observations;
    private UserDTO userDTO;

    private CelestialObjectDTO celestialObjectDTO;
}
