package com.traveather.journey.service.mapper;

import com.traveather.journey.api.model.Journey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JourneyMapper {

    Journey asDto(com.traveather.journey.repository.model.Journey journey);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    com.traveather.journey.repository.model.Journey asEntity(Journey journey);
}
