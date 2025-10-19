package com.autosos.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmergencyReportRequest {

    @NotBlank
    @Size(max = 50)
    private String type;

    @NotBlank
    @Size(max = 500)
    private String description;

    @NotBlank
    @Size(max = 255)
    private String location;

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
}
