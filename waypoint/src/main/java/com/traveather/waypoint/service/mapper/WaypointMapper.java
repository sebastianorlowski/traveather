package com.traveather.waypoint.service.mapper;

import com.traveather.waypoint.repository.model.Waypoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WaypointMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    Waypoint asEntity(com.traveather.waypoint.api.model.Waypoint waypoint);

    com.traveather.waypoint.api.model.Waypoint asDto(Waypoint waypoint);

    default List<com.traveather.waypoint.api.model.Waypoint> asListDto(List<Waypoint> waypoints) {
        return waypoints.stream()
                .map(this::asDto)
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    void update(@MappingTarget Waypoint existingWaypoint, Waypoint waypoint);
}
