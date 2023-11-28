package com.traveather.waypoint.service.mapper;

import com.traveather.waypoint.repository.model.Country;
import com.traveather.waypoint.repository.model.Waypoint;
import com.traveather.waypoint.service.model.WaypointMessaging;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WaypointEventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "info", ignore = true)
    Waypoint asWaypoint(WaypointMessaging waypointMessaging);
}
