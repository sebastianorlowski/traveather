package com.traveather.journey.repository.model;

import com.traveather.common.entity.AuditableEntity;
import com.traveather.destination.repository.model.Destination;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "journeys")
public class Journey extends AuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "archived")
    private boolean archived;

    @ManyToMany
    @JoinTable(
            name = "journey_destinations",
            joinColumns = @JoinColumn(name = "journey_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private List<Destination> destinations;

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
