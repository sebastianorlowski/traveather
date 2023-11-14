package com.traveather.destination.repository;

import com.traveather.destination.repository.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaypointRepository extends JpaRepository<Long, Waypoint> {
}
