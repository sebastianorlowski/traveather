package com.traveather.journey.service;

import com.traveather.journey.api.model.Journey;
import com.traveather.journey.repository.JourneyRepository;
import com.traveather.journey.service.mapper.JourneyMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JourneyService {

    private final JourneyRepository journeyRepository;
    private final JourneyMapper journeyMapper;

    public JourneyService(JourneyRepository journeyRepository, JourneyMapper journeyMapper) {
        this.journeyRepository = journeyRepository;
        this.journeyMapper = journeyMapper;
    }

    public Journey createJourney(Journey journey) {
        var journeyEntity = journeyMapper.asEntity(journey);
        var createdJourney = journeyRepository.save(journeyEntity);
        return journeyMapper.asDto(createdJourney);
    }

    public Journey retrieveJourneyById(String id) {
        Optional<com.traveather.journey.repository.model.Journey> journeyEntity =
                journeyRepository.findJourneyByExternalId(UUID.fromString(id));
        return journeyEntity.map(journeyMapper::asDto)
                .orElseThrow(() -> new RuntimeException("Journey with id {} not found."));
    }
}
