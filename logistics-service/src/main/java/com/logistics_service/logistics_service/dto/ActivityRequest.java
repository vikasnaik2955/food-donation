package com.logistics_service.logistics_service.dto;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
public class ActivityRequest {
    private String title;
    private String description;
    private String location;
    private UUID createdByVolunteerId;
    private UUID groupId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public UUID getCreatedByVolunteerId() {
        return createdByVolunteerId;
    }

    public UUID getGroupId() {
        return groupId;
    }


}

