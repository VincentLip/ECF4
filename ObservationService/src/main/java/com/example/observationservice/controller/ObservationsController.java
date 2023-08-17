package com.example.observationservice.controller;

import com.example.observationservice.dto.ObservationsResponseDTO;
import com.example.observationservice.entity.Observations;
import com.example.observationservice.service.ObservationsService;
import com.example.observationservice.tool.RestClient;
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

    @PostMapping("")
    public ResponseEntity<Observations> post(@RequestParam int userId,@RequestParam int celestialObjectId,@RequestParam Date date,@RequestParam String description,@RequestParam String urlPicture) {
//        RestClient<String, String> restClient = new RestClient<>();
//        if(restClient.testToken(token, String.class)) {
//            Order order = orderService.createOrder(userId, productName);
//            return ResponseEntity.ok(order);
//        }
//        return ResponseEntity.status(401).body(null);
        Observations observations = observationsService.createObservations(userId,celestialObjectId,description,date,urlPicture );
        return ResponseEntity.ok(observations);
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
