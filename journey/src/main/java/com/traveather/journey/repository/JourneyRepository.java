package com.traveather.journey.repository;

import com.traveather.journey.repository.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {

    Optional<Journey> findJourneyByExternalId(String externalId);
}
