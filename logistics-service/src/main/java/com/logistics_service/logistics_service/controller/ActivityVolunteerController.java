package com.logistics_service.logistics_service.controller;

import com.logistics_service.logistics_service.dto.InviteVolunteerRequest;
import com.logistics_service.logistics_service.service.ActivityVolunteerService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/activities/{activityId}")
public class ActivityVolunteerController {

    private final ActivityVolunteerService service;

    public ActivityVolunteerController(ActivityVolunteerService service) {
        this.service = service;
    }

    @PostMapping("/invite")
    public void inviteVolunteer(
            @PathVariable UUID activityId,
            @RequestBody InviteVolunteerRequest request) {
        service.inviteVolunteer(activityId, request);
    }

    @PatchMapping("/accept/{volunteerId}")
    public void acceptInvitation(
            @PathVariable UUID activityId,
            @PathVariable UUID volunteerId) {
        service.acceptInvitation(activityId, volunteerId);
    }

    @PatchMapping("/reject/{volunteerId}")
    public void rejectInvitation(
            @PathVariable UUID activityId,
            @PathVariable UUID volunteerId) {
        service.rejectInvitation(activityId, volunteerId);
    }
}

