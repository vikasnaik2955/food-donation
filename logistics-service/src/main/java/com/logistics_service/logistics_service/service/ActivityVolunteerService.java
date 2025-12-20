package com.logistics_service.logistics_service.service;

import com.logistics_service.logistics_service.dto.InviteVolunteerRequest;

import java.util.UUID;

public interface ActivityVolunteerService {

    void inviteVolunteer(UUID activityId, InviteVolunteerRequest request);

    void acceptInvitation(UUID activityId, UUID volunteerId);

    void rejectInvitation(UUID activityId, UUID volunteerId);
}

