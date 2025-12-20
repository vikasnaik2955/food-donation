package com.logistics_service.logistics_service.dto;



import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class VolunteerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    @Email
    private String email;

    @NotBlank
    private String location;

    private String qualification;

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getQualification() {
        return qualification;
    }
}
