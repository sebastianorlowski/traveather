package com.traveather.waypoint.service.mapper;

import com.traveather.waypoint.repository.model.Country;
import com.traveather.waypoint.repository.model.Waypoint;
import com.traveather.waypoint.service.model.WaypointMessaging;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {

   Country asCountry(WaypointMessaging waypointMessaging);
}
