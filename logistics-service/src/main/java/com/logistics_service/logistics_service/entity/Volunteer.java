package com.logistics_service.logistics_service.entity;


import com.logistics_service.logistics_service.enums.VolunteerStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "volunteers")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Volunteer extends BaseEntity {

    private String name;

    private String contact;

    private String email;

    private String location;

    private String qualification;

    @Enumerated(EnumType.STRING)
    private VolunteerStatus status = VolunteerStatus.AVAILABLE;


    public Volunteer() {
    }

    private Volunteer(Builder builder) {
        this.name = builder.name;
        this.contact = builder.contact;
        this.email = builder.email;
        this.location = builder.location;
        this.qualification = builder.qualification;
        this.status = builder.status != null ? builder.status : VolunteerStatus.AVAILABLE;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String name;
        private String contact;
        private String email;
        private String location;
        private String qualification;
        private VolunteerStatus status;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder qualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public Builder status(VolunteerStatus status) {
            this.status = status;
            return this;
        }

        public Volunteer build() {
            if (name == null || name.isBlank()) {
                throw new IllegalStateException("Volunteer name is required");
            }
            if (contact == null || contact.isBlank()) {
                throw new IllegalStateException("Volunteer contact is required");
            }
            if (location == null || location.isBlank()) {
                throw new IllegalStateException("Volunteer location is required");
            }
            return new Volunteer(this);
        }
    }
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

    public VolunteerStatus getStatus() {
        return status;
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
