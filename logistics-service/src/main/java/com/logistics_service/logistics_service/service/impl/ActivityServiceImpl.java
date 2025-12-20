package com.logistics_service.logistics_service.service.impl;

import com.logistics_service.logistics_service.dto.ActivityRequest;
import com.logistics_service.logistics_service.entity.Activity;
import com.logistics_service.logistics_service.repository.ActivityRepository;
import com.logistics_service.logistics_service.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository repository;

    public ActivityServiceImpl(ActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Activity create(ActivityRequest request) {
        Activity activity = Activity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .createdByVolunteerId(request.getCreatedByVolunteerId())
                .groupId(request.getGroupId())
                .build();

        return repository.save(activity);
    }

    @Override
    public Activity getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
    }

    @Override
    public List<Activity> getAll() {
        return repository.findAll();
    }

    @Override
    public Activity update(UUID id, ActivityRequest request) {
        Activity activity = getById(id);
        activity.setTitle(request.getTitle());
        activity.setDescription(request.getDescription());
        activity.setLocation(request.getLocation());
        return repository.save(activity);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(getById(id));
    }
}

