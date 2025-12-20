package com.logistics_service.logistics_service.entity;

import com.logistics_service.logistics_service.enums.ActivityRole;
import com.logistics_service.logistics_service.enums.ParticipationStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Builder
@Data
@Table(name = "activity_volunteers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"activity_id", "volunteer_id"}))
public class ActivityVolunteer extends BaseEntity {

    private UUID activityId;

    private UUID volunteerId;

    private UUID addedByVolunteerId;

    @Enumerated(EnumType.STRING)
    private ParticipationStatus status; // INVITED, ACCEPTED, REJECTED

    @Enumerated(EnumType.STRING)
    private ActivityRole role; // CREATOR, PARTICIPANT

    public ActivityVolunteer() {
    }

    private ActivityVolunteer(Builder builder) {
        this.activityId = builder.activityId;
        this.volunteerId = builder.volunteerId;
        this.addedByVolunteerId = builder.addedByVolunteerId;
        this.status = builder.status;
        this.role = builder.role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID activityId;
        private UUID volunteerId;
        private UUID addedByVolunteerId;
        private ParticipationStatus status;
        private ActivityRole role;

        private Builder() {
        }

        public Builder activityId(UUID activityId) {
            this.activityId = activityId;
            return this;
        }

        public Builder volunteerId(UUID volunteerId) {
            this.volunteerId = volunteerId;
            return this;
        }

        public Builder addedByVolunteerId(UUID addedByVolunteerId) {
            this.addedByVolunteerId = addedByVolunteerId;
            return this;
        }

        public Builder status(ParticipationStatus status) {
            this.status = status;
            return this;
        }

        public Builder role(ActivityRole role) {
            this.role = role;
            return this;
        }

        public ActivityVolunteer build() {
            if (activityId == null || volunteerId == null || addedByVolunteerId == null) {
                throw new IllegalStateException("Required fields are missing");
            }
            if (status == null) {
                throw new IllegalStateException("Participation status is required");
            }
            if (role == null) {
                throw new IllegalStateException("Activity role is required");
            }
            return new ActivityVolunteer(this);
        }
    }

    public void setActivityId(UUID activityId) {
        this.activityId = activityId;
    }

    public void setVolunteerId(UUID volunteerId) {
        this.volunteerId = volunteerId;
    }

    public void setAddedByVolunteerId(UUID addedByVolunteerId) {
        this.addedByVolunteerId = addedByVolunteerId;
    }

    public void setStatus(ParticipationStatus status) {
        this.status = status;
    }

    public void setRole(ActivityRole role) {
        this.role = role;
    }
}
