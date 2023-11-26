package com.traveather.journey.api;

import com.traveather.journey.api.model.Journey;
import com.traveather.journey.api.validation.JourneyValidator;
import com.traveather.journey.service.JourneyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class JourneyController implements JourneyApi {

    private final JourneyService journeyService;
    private final JourneyValidator journeyValidator;

    @Override
    public ResponseEntity<Journey> createJourney(Journey journey) {
        journeyValidator.validateCreateJourney(journey);
        return ResponseEntity.ok(journeyService.createJourney(journey));
    }

    @Override
    public ResponseEntity<Journey> retrieveJourney(String id) {
        return ResponseEntity.ok(journeyService.retrieveJourneyById(id));
    }

    @Override
    public ResponseEntity<List<Journey>> retrieveJourneysList() {
        return ResponseEntity.ok(journeyService.retrieveAllJourneys());
    }

    @Override
    public ResponseEntity<Journey> updateOrCreateJourney(String id, Journey journey) {
        return ResponseEntity.ok(journeyService.createOrUpdateJourney(id, journey));
    }
}
