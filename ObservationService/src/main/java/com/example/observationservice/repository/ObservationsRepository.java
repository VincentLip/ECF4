package com.example.observationservice.repository;

import com.example.observationservice.entity.Observations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ObservationsRepository extends CrudRepository<Observations,Integer> {

    List<Observations> findObservationsByUserId(int userId);
    List<Observations> findObservationsByCelestialObjectId(int celestialObjectId);

    List<Observations> findObservationsByDate(Date date);



}
