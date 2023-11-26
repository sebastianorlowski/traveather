package com.traveather.destination.api;

import com.traveather.destination.api.model.Destination;
import com.traveather.destination.service.DestinationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DestinationController implements DestinationApi {

    private final DestinationService destinationService;

    @Override
    public ResponseEntity<Destination> createDestination(Destination destination) {
        return ResponseEntity.ok(destinationService.createDestination(destination));
    }

    @Override
    public ResponseEntity<Destination> retrieveDestination(String id) {
        return ResponseEntity.ok(destinationService.retrieveDestinationById(id));
    }

    @Override
    public ResponseEntity<List<Destination>> retrieveDestinationsList() {
        return ResponseEntity.ok(destinationService.retrieveAllDestinations());
    }

    @Override
    public ResponseEntity<Destination> updateOrCreateDestination(String id, Destination destination) {
        return ResponseEntity.ok(destinationService.createOrUpdateDestination(id, destination));
    }
}
