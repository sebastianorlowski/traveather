package com.traveather.waypoint.service;

import com.traveather.waypoint.api.model.Waypoint;
import com.traveather.waypoint.repository.WaypointRepository;
import com.traveather.waypoint.service.event.WaypointEvent;
import com.traveather.waypoint.service.mapper.WaypointMapper;
import com.traveather.waypoint.service.mapper.WaypointEventMapper;
import com.traveather.waypoint.service.model.WaypointMessaging;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WaypointService {

    private final WaypointRepository waypointRepository;
    private final WaypointMapper waypointMapper;
    private final WaypointEvent waypointEvent;
    private final WaypointEventMapper waypointEventMapper;
    private final CountryService countryService;

    public Waypoint createWaypoint(Waypoint waypoint) {
        var waypointEntity = waypointMapper.asEntity(waypoint);
        var createdWaypoint = waypointRepository.save(waypointEntity);
        waypointEvent.publishOnCreate(createdWaypoint);
        return waypointMapper.asDto(createdWaypoint);
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

    public void updateWaypointData(WaypointMessaging waypointMessaging) {
        countryService.createOrUpdateCountry(waypointMessaging);
    }

    private Waypoint updateWaypoint(Waypoint newWaypoint, com.traveather.waypoint.repository.model.Waypoint existingWaypoint) {
        var newWaypointEntity = waypointMapper.asEntity(newWaypoint);
        waypointMapper.update(newWaypointEntity, existingWaypoint);
        return waypointMapper.asDto(existingWaypoint);
    }
}
