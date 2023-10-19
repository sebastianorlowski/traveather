package com.traveather.identity_provider.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "external_id")
    private UUID externalId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    public void setExternalId(UUID externalId) {
        if (externalId == null) {
            externalId = UUID.randomUUID();
        }
        this.externalId = externalId;
    }
}
