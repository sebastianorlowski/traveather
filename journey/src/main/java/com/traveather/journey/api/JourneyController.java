package com.traveather.journey.api;

import com.traveather.journey.api.model.Journey;
import com.traveather.journey.service.JourneyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JourneyController implements JourneyApi {

    private final JourneyService journeyService;

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @Override
    public ResponseEntity<Journey> createJourney(Journey journey) {
        return ResponseEntity.ok(journeyService.createJourney(journey));
    }

    @Override
    public ResponseEntity<Journey> retrieveJourney(String id) {
        return JourneyApi.super.retrieveJourney(id);
    }

    @Override
    public ResponseEntity<List<Journey>> retrieveJourneysList() {
        return JourneyApi.super.retrieveJourneysList();
    }

    @Override
    public ResponseEntity<Journey> updateOrCreateJourney(String id, Journey journey) {
        return JourneyApi.super.updateOrCreateJourney(id, journey);
    }
}
