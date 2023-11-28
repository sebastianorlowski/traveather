package com.traveather.waypoint.service;

import com.traveather.waypoint.repository.CountryRepository;
import com.traveather.waypoint.repository.model.Country;
import com.traveather.waypoint.service.mapper.CountryMapper;
import com.traveather.waypoint.service.mapper.WaypointEventMapper;
import com.traveather.waypoint.service.model.WaypointMessaging;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    public void createOrUpdateCountry(WaypointMessaging waypointMessaging) {
        Country country = countryMapper.asCountry(waypointMessaging);
        countryRepository.save(country);
    }
}
