package com.traveather.journey.service;

import com.traveather.journey.api.model.Journey;
import com.traveather.journey.repository.JourneyRepository;
import org.springframework.stereotype.Service;

@Service
public class JourneyService {

    private final JourneyRepository journeyRepository;

    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public Journey createJourney(Journey journey) {
        return null;
    }
}
