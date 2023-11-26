package com.traveather.waypoint.service;

import com.traveather.waypoint.api.model.Waypoint;
import com.traveather.waypoint.repository.WaypointRepository;
import com.traveather.waypoint.service.mapper.WaypointMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WaypointService {

    private final WaypointRepository waypointRepository;
    private final WaypointMapper waypointMapper;

    public WaypointService(WaypointRepository waypointRepository,
                           WaypointMapper waypointMapper) {
        this.waypointRepository = waypointRepository;
        this.waypointMapper = waypointMapper;
    }

    public Waypoint createWaypoint(Waypoint waypoint) {
        var waypointEntity = waypointMapper.asEntity(waypoint);
        var createdWaypoint = waypointRepository.save(waypointEntity);
        Waypoint waypointDto = waypointMapper.asDto(createdWaypoint);
        return waypointDto;
    }

    public Waypoint createOrUpdateWaypoint(String id, Waypoint waypointDto) {
        return waypointRepository.findWaypointByExternalId(id)
                .map(waypointEntity -> updateWaypoint(waypointDto, waypointEntity))
                .orElseGet(() -> createWaypoint(waypointDto));
    }

    public Waypoint retrieveWaypointById(String id) {
        return waypointRepository.findWaypointByExternalId(id)
                .map(waypointMapper::asDto)
                .orElseThrow(() -> new RuntimeException("Waypoint with id {} not found."));
    }

    public List<Waypoint> retrieveAllWaypoints() {
        List<com.traveather.waypoint.repository.model.Waypoint> waypointList =
                waypointRepository.findAll();
        return waypointMapper.asListDto(waypointList);
    }

    private Waypoint updateWaypoint(Waypoint newWaypoint, com.traveather.waypoint.repository.model.Waypoint existingWaypoint) {
        var newWaypointEntity = waypointMapper.asEntity(newWaypoint);
        waypointMapper.update(newWaypointEntity, existingWaypoint);
        return waypointMapper.asDto(existingWaypoint);
    }

}
