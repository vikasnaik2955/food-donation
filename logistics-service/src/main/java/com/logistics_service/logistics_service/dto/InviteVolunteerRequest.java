package com.logistics_service.logistics_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class InviteVolunteerRequest {
    private UUID volunteerId;
    private UUID addedByVolunteerId;

    public UUID getVolunteerId() {
        return volunteerId;
    }

    public UUID getAddedByVolunteerId() {
        return addedByVolunteerId;
    }
}

