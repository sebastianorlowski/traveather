package com.traveather.waypoint.api;

import com.traveather.waypoint.api.model.Waypoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WaypointController implements WaypointApi {

    @Override
    public ResponseEntity<Waypoint> createWaypoint(Waypoint waypoint) {
        return WaypointApi.super.createWaypoint(waypoint);
    }

    @Override
    public ResponseEntity<Waypoint> retrieveWaypoint(String id) {
        return WaypointApi.super.retrieveWaypoint(id);
    }

    @Override
    public ResponseEntity<List<Waypoint>> retrieveWaypointsList() {
        return WaypointApi.super.retrieveWaypointsList();
    }

    @Override
    public ResponseEntity<Waypoint> updateOrCreateWaypoint(String id, Waypoint waypoint) {
        return WaypointApi.super.updateOrCreateWaypoint(id, waypoint);
    }
}
