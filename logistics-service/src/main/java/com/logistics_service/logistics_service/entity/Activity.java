package com.logistics_service.logistics_service.entity;

import com.logistics_service.logistics_service.enums.ActivityStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "activities")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Activity extends BaseEntity {

    private String title;

    private String description;

    private String location;

    @Enumerated(EnumType.STRING)
    private ActivityStatus status = ActivityStatus.OPEN;

    // Volunteer who created this activity
    private UUID createdByVolunteerId;

    // Optional group (friends / NGO / society)
    private UUID groupId;


    public Activity() {
    }

    private Activity(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.location = builder.location;
        this.status = builder.status != null ? builder.status : ActivityStatus.OPEN;
        this.createdByVolunteerId = builder.createdByVolunteerId;
        this.groupId = builder.groupId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String title;
        private String description;
        private String location;
        private ActivityStatus status;
        private UUID createdByVolunteerId;
        private UUID groupId;

        private Builder() {
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder status(ActivityStatus status) {
            this.status = status;
            return this;
        }

        public Builder createdByVolunteerId(UUID createdByVolunteerId) {
            this.createdByVolunteerId = createdByVolunteerId;
            return this;
        }

        public Builder groupId(UUID groupId) {
            this.groupId = groupId;
            return this;
        }

        public Activity build() {
            return new Activity(this);
        }

    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public void setCreatedByVolunteerId(UUID createdByVolunteerId) {
        this.createdByVolunteerId = createdByVolunteerId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}

