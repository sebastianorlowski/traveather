package com.traveather.destination.repository.destination;

import com.traveather.destination.repository.destination.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Long, Destination> {
}
