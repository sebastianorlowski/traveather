package com.traveather.journey.api;

import com.traveather.journey.api.model.Journey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JourneyController implements JourneyApi {

    @Override
    public ResponseEntity<Journey> createJourney(Journey journey) {
        return JourneyApi.super.createJourney(journey);
    }

    @Override
    public ResponseEntity<Journey> retrieveJourney(String id) {
        return JourneyApi.super.retrieveJourney(id);
    }

    @Override
    public ResponseEntity<List<Journey>> retrieveJourneyList() {
        return JourneyApi.super.retrieveJourneyList();
    }

    @Override
    public ResponseEntity<Journey> updateOrCreateJourney(String id, Journey journey) {
        return JourneyApi.super.updateOrCreateJourney(id, journey);
    }
}
