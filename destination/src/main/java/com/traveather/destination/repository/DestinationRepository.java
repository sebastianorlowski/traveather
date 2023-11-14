package com.traveather.destination.repository;

import com.traveather.destination.repository.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    Optional<Destination> findDestinationByExternalId(UUID externalId);
}
