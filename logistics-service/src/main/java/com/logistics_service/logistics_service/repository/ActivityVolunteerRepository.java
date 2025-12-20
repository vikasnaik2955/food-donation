package com.logistics_service.logistics_service.repository;

import com.logistics_service.logistics_service.entity.ActivityVolunteer;
import com.logistics_service.logistics_service.enums.ParticipationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActivityVolunteerRepository
        extends JpaRepository<ActivityVolunteer, UUID> {

    Optional<ActivityVolunteer> findByActivityIdAndVolunteerId(
            UUID activityId, UUID volunteerId);

    List<ActivityVolunteer> findByActivityIdAndStatus(
            UUID activityId, ParticipationStatus status);
}

