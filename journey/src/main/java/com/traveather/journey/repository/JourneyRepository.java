package com.traveather.journey.repository;

import com.traveather.journey.api.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {

}
