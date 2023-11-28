package com.traveather.waypoint.repository;

import com.traveather.waypoint.repository.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
