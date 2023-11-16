package com.traveather.destination.repository;

import com.traveather.destination.repository.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaypointRepository extends JpaRepository<Waypoint, Long> {
}
