package com.autosos.backend.dto;

import java.time.OffsetDateTime;

public class EmergencyReportResponse {

    private Long id;
    private String username;
    private String type;
    private String description;
    private String location;
    private OffsetDateTime timestamp;

    public EmergencyReportResponse(Long id, String username, String type, String description, String location,
                                   OffsetDateTime timestamp) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.description = description;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
