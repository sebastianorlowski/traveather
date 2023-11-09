package com.traveather.waypoint.repository.waypoint;

import com.traveather.waypoint.repository.waypoint.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaypointRepository extends JpaRepository<Long, Waypoint> {
}
