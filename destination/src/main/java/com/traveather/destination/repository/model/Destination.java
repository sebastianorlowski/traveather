package com.traveather.destination.repository.model;

import com.traveather.common.entity.AuditableEntity;
import com.traveather.waypoint.repository.model.Waypoint;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "destination_waypoints",
            joinColumns = @JoinColumn(name = "destination_id"),
            inverseJoinColumns = @JoinColumn(name = "waypoint_id")
    )
    private List<Waypoint> waypoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }
}
