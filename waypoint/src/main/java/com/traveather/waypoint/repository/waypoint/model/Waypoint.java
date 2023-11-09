package com.traveather.waypoint.repository.waypoint.model;

import com.traveather.common.entity.AuditableEntity;
import com.traveather.waypoint.repository.destination.model.Destination;
import jakarta.persistence.*;

@Entity
@Table(name = "waypoints")
public class Waypoint extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
}
