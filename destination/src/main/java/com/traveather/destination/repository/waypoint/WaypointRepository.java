package com.traveather.destination.repository.waypoint;

import com.traveather.destination.repository.waypoint.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaypointRepository extends JpaRepository<Long, Waypoint> {
}
