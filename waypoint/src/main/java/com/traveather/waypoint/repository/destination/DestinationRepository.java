package com.traveather.waypoint.repository.destination;

import com.traveather.waypoint.repository.destination.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Long, Destination> {
}
