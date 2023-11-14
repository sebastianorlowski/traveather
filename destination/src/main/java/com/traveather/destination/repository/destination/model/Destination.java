package com.traveather.destination.repository.destination.model;

import com.traveather.common.entity.AuditableEntity;
import com.traveather.destination.repository.waypoint.model.Waypoint;
import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "description")
    private String description;

    @OneToMany()
    private List<Waypoint> waypoints;
}
