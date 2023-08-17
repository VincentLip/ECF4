package com.example.observationservice.controller;

import com.example.observationservice.dto.ObservationsResponseDTO;
import com.example.observationservice.entity.Observations;
import com.example.observationservice.service.ObservationsService;
import com.example.observationservice.tool.RestClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/observation")
public class ObservationsController {

    private final ObservationsService observationsService;

    public ObservationsController(ObservationsService observationsService) {
        this.observationsService = observationsService;
    }

//    @PostMapping("") sans security
//    public ResponseEntity<Observations> post(@RequestParam int userId,@RequestParam int celestialObjectId,@RequestParam Date date,@RequestParam String description,@RequestParam String urlPicture) {
//        Observations observations = observationsService.createObservations(userId,celestialObjectId,description,date,urlPicture );
//        return ResponseEntity.ok(observations);
//    }

    @PostMapping("")
    public ResponseEntity<Observations> post(@RequestParam int userId,@RequestParam int celestialObjectId,@RequestParam Date date,@RequestParam String description,@RequestParam String urlPicture, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        RestClient<String, String> restClient = new RestClient<>();
        if(restClient.testToken(token, String.class)) {
            Observations observations = observationsService.createObservations(userId,celestialObjectId,description,date,urlPicture );
            return ResponseEntity.ok(observations);
        }
        return ResponseEntity.status(401).body(null);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<ObservationsResponseDTO> getUser(@PathVariable int userId) {
                return ResponseEntity.ok(observationsService.getObservationsByUserId(userId));
    }

    @GetMapping("celest/{celestObjectId}")
    public ResponseEntity<ObservationsResponseDTO> getCelestialObject(@PathVariable int celestObjectId) {
        return ResponseEntity.ok(observationsService.getObservationsByCelestialObjectId(celestObjectId));
    }

}
