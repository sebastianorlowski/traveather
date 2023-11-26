package com.traveather.journey.service;

import com.traveather.journey.api.model.Journey;
import com.traveather.journey.repository.JourneyRepository;
import com.traveather.journey.service.mapper.JourneyMapper;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class JourneyService {

    private final JourneyRepository journeyRepository;
    private final JourneyMapper journeyMapper;

    public Journey createJourney(Journey journey) {
        var journeyEntity = journeyMapper.asEntity(journey);
        var createdJourney = journeyRepository.save(journeyEntity);
        return journeyMapper.asDto(createdJourney);
    }

    public Journey createOrUpdateJourney(String id, Journey journeyDto) {
        return journeyRepository.findJourneyByExternalId(id)
                .map(journeyEntity -> updateJourney(journeyDto, journeyEntity))
                .orElseGet(() -> createJourney(journeyDto));
    }

    public Journey retrieveJourneyById(String id) {
        return journeyRepository.findJourneyByExternalId(id)
                .map(journeyMapper::asDto)
                .orElseThrow(() -> new RuntimeException("Journey with id {} not found."));
    }

    public List<Journey> retrieveAllJourneys() {
        List<com.traveather.journey.repository.model.Journey> journeyList =
                journeyRepository.findAll();
        return journeyMapper.asListDto(journeyList);
    }

    private Journey updateJourney(Journey newJourney, com.traveather.journey.repository.model.Journey existingJourney) {
        var newJourneyEntity = journeyMapper.asEntity(newJourney);
        journeyMapper.update(newJourneyEntity, existingJourney);
        return journeyMapper.asDto(existingJourney);
    }
}
