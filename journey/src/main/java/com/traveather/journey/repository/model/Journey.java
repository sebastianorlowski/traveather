package com.traveather.journey.repository.model;

import com.traveather.identity_provider.repository.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "journeys")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "external_id")
    private UUID externalId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_by")
    private User createdBy;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "modified_by")
    private User modifiedBy;

    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;

    @Column(name = "archived")
    private boolean archived;

    @Column(name = "description")
    private String description;

//    @Column(name = "waypoints")
//    @OneToMany
//    private List<Waypoint> waypoints;
//

    @PrePersist
    private void prePersist() {
        OffsetDateTime now = OffsetDateTime.now();
        if (this.externalId == null) {
            this.externalId = UUID.randomUUID();
        }
        if (this.createdAt == null) {
            this.createdAt = now;
        }
        if (this.createdBy == null) {
            this.createdBy = new User();
        }
        this.modifiedAt = now;
        this.modifiedBy = new User();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
