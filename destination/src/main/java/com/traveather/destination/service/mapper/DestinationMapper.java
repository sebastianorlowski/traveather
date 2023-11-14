package com.traveather.destination.service.mapper;

import com.traveather.destination.api.model.Destination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    @Mapping(target = "id", source = "externalId")
    Destination asDto(com.traveather.destination.repository.model.Destination destination);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    // TODO: Extend waypoints
    @Mapping(target = "waypoints", ignore = true)
    com.traveather.destination.repository.model.Destination asEntity(Destination destination);

    default List<Destination> asListDto(List<com.traveather.destination.repository.model.Destination> destinationList) {
        return destinationList.stream()
                .map(this::asDto)
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    // TODO: Extend waypoints
    @Mapping(target = "waypoints", ignore = true)
    void update(@MappingTarget com.traveather.destination.repository.model.Destination existingDestination,
                com.traveather.destination.repository.model.Destination destination);
}
