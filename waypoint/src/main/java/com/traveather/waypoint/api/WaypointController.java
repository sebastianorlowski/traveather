package com.traveather.waypoint.api;

import com.traveather.waypoint.api.model.Waypoint;
import com.traveather.waypoint.service.WaypointService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WaypointController implements WaypointsApi {

    private final WaypointService waypointService;

    @Override
    public ResponseEntity<Waypoint> createWaypoint(@RequestBody Waypoint waypoint) {
        return ResponseEntity.ok(waypointService.createWaypoint(waypoint));
    }

    @Override
    public ResponseEntity<Waypoint> retrieveWaypoint(@PathVariable String id) {
        return ResponseEntity.ok(waypointService.retrieveWaypointById(id));
    }

    @Override
    public ResponseEntity<List<Waypoint>> retrieveWaypointsList() {
        return ResponseEntity.ok(waypointService.retrieveAllWaypoints());
    }

    @Override
    public ResponseEntity<Waypoint> updateOrCreateWaypoint(@PathVariable String id, @RequestBody Waypoint waypoint) {
        return ResponseEntity.ok(waypointService.createOrUpdateWaypoint(id, waypoint));
    }
}
