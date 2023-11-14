package com.traveather.journey.service.mapper;

import com.traveather.journey.api.model.Journey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface JourneyMapper {

    @Mapping(target = "id", source = "externalId")
    Journey asDto(com.traveather.journey.repository.model.Journey journey);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "destinations", ignore = true)
    com.traveather.journey.repository.model.Journey asEntity(Journey journey);

    default List<Journey> asListDto(List<com.traveather.journey.repository.model.Journey> journeyList) {
        return journeyList.stream()
                .map(this::asDto)
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "destinations", ignore = true)
    void update(@MappingTarget com.traveather.journey.repository.model.Journey existingJourney,
                                                           com.traveather.journey.repository.model.Journey journey);
}
