package com.traveather.destination.service;

import com.traveather.destination.api.model.Destination;
import com.traveather.destination.repository.DestinationRepository;
import com.traveather.destination.service.mapper.DestinationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DestinationService {


    private final DestinationRepository destinationRepository;
    private final DestinationMapper destinationMapper;

    public DestinationService(DestinationRepository destinationRepository, DestinationMapper destinationMapper) {
        this.destinationRepository = destinationRepository;
        this.destinationMapper = destinationMapper;
    }

    public Destination createDestination(Destination destination) {
        var destinationEntity = destinationMapper.asEntity(destination);
        var createdDestination = destinationRepository.save(destinationEntity);
        return destinationMapper.asDto(createdDestination);
    }

    public Destination createOrUpdateDestination(String id, Destination destinationDto) {
        return destinationRepository.findDestinationByExternalId(UUID.fromString(id))
                .map(destinationEntity -> updateDestination(destinationDto, destinationEntity))
                .orElseGet(() -> createDestination(destinationDto));
    }

    public Destination retrieveDestinationById(String id) {
        return destinationRepository.findDestinationByExternalId(UUID.fromString(id))
                .map(destinationMapper::asDto)
                .orElseThrow(() -> new RuntimeException("Destination with id {} not found."));
    }

    public List<Destination> retrieveAllDestinations() {
        List<com.traveather.destination.repository.model.Destination> destinationList =
                destinationRepository.findAll();
        return destinationMapper.asListDto(destinationList);
    }

    private Destination updateDestination(Destination newDestination, com.traveather.destination.repository.model.Destination existingDestination) {
        var newDestinationEntity = destinationMapper.asEntity(newDestination);
        destinationMapper.update(newDestinationEntity, existingDestination);
        return destinationMapper.asDto(existingDestination);
    }
}
