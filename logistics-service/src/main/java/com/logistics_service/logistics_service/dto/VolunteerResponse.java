package com.logistics_service.logistics_service.dto;


import com.logistics_service.logistics_service.enums.VolunteerStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class VolunteerResponse {

    private UUID id;

    private String name;

    private String contact;

    private String email;

    private String location;

    private String qualification;

    private VolunteerStatus status;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setStatus(VolunteerStatus status) {
        this.status = status;
    }
}

