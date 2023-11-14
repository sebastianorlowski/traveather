package com.traveather.destination.api;

import com.traveather.destination.api.model.Destination;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DestinationController implements DestinationApi {

    @Override
    public ResponseEntity<Destination> createDestination(Destination destination) {
        return DestinationApi.super.createDestination(destination);
    }

    @Override
    public ResponseEntity<Destination> retrieveDestination(String id) {
        return DestinationApi.super.retrieveDestination(id);
    }

    @Override
    public ResponseEntity<List<Destination>> retrieveDestinationsList() {
        return DestinationApi.super.retrieveDestinationsList();
    }

    @Override
    public ResponseEntity<Destination> updateOrCreateDestination(String id, Destination destination) {
        return DestinationApi.super.updateOrCreateDestination(id, destination);
    }
}
