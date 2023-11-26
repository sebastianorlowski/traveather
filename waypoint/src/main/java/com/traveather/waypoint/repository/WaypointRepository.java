package com.traveather.waypoint.repository;

import com.traveather.waypoint.repository.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WaypointRepository extends JpaRepository<Waypoint, Long> {

    Optional<Waypoint> findWaypointByExternalId(String externalId);
}
