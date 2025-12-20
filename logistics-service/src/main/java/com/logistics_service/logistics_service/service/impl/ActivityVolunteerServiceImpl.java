package com.logistics_service.logistics_service.service.impl;

import com.logistics_service.logistics_service.dto.InviteVolunteerRequest;
import com.logistics_service.logistics_service.entity.ActivityVolunteer;
import com.logistics_service.logistics_service.enums.ActivityRole;
import com.logistics_service.logistics_service.enums.ParticipationStatus;
import com.logistics_service.logistics_service.repository.ActivityVolunteerRepository;
import com.logistics_service.logistics_service.service.ActivityVolunteerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActivityVolunteerServiceImpl implements ActivityVolunteerService {

    private final ActivityVolunteerRepository repository;

    public ActivityVolunteerServiceImpl(ActivityVolunteerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void inviteVolunteer(UUID activityId, InviteVolunteerRequest request) {

        ActivityVolunteer av = ActivityVolunteer.builder()
                .activityId(activityId)
                .volunteerId(request.getVolunteerId())
                .addedByVolunteerId(request.getAddedByVolunteerId())
                .status(ParticipationStatus.INVITED)
                .role(ActivityRole.PARTICIPANT)
                .build();

        repository.save(av);
    }

    @Override
    public void acceptInvitation(UUID activityId, UUID volunteerId) {
        ActivityVolunteer av = repository
                .findByActivityIdAndVolunteerId(activityId, volunteerId)
                .orElseThrow(() -> new IllegalArgumentException("Invitation not found"));

        av.setStatus(ParticipationStatus.ACCEPTED);
        repository.save(av);
    }

    @Override
    public void rejectInvitation(UUID activityId, UUID volunteerId) {
        ActivityVolunteer av = repository
                .findByActivityIdAndVolunteerId(activityId, volunteerId)
                .orElseThrow(() -> new IllegalArgumentException("Invitation not found"));

        av.setStatus(ParticipationStatus.REJECTED);
        repository.save(av);
    }
}

