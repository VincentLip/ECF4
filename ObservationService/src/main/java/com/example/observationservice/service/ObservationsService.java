package com.example.observationservice.service;

import com.example.observationservice.dto.CelestialObjectDTO;
import com.example.observationservice.dto.ObservationsResponseDTO;
import com.example.observationservice.dto.UserDTO;
import com.example.observationservice.entity.Observations;
import com.example.observationservice.repository.ObservationsRepository;
import com.example.observationservice.tool.RestClient;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ObservationsService {

    private final ObservationsRepository observationsRepository;

    public ObservationsService(ObservationsRepository observationsRepository) {
        this.observationsRepository = observationsRepository;
    }

    public Observations createObservations(int userId, int celestialObjectId, String description, Date date, String urlPicture) {
        Observations observations = Observations.builder().userId(userId).celestialObjectId(celestialObjectId).descriptions(description).date(date).urlPicture(urlPicture).build();
        observationsRepository.save(observations);
        return observations;
    }

    public ObservationsResponseDTO getObservationsByUserId(int userId) {
        RestClient<UserDTO, String> restClient = new RestClient<>();
        ObservationsResponseDTO observationsResponseDTO = ObservationsResponseDTO.builder()
                .observations(observationsRepository.findObservationsByUserId(userId))
                .userDTO(restClient.getUtilisateur("user/"+userId, UserDTO.class))
                .build();
        return observationsResponseDTO;
    }

    public ObservationsResponseDTO getObservationsByCelestialObjectId(int celestialObjectId) {
        RestClient<UserDTO, String> restClient = new RestClient<>();
        ObservationsResponseDTO observationsResponseDTO = ObservationsResponseDTO.builder()
                .observations(observationsRepository.findObservationsByCelestialObjectId(celestialObjectId))
                .celestialObjectDTO(restClient.getCelestialObject("celest/"+celestialObjectId, CelestialObjectDTO.class))
                .build();
        return observationsResponseDTO;
    }

}
