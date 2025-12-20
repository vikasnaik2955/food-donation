package com.logistics_service.logistics_service.service;

import com.logistics_service.logistics_service.dto.ActivityRequest;
import com.logistics_service.logistics_service.entity.Activity;

import java.util.List;
import java.util.UUID;

public interface ActivityService {

    Activity create(ActivityRequest request);

    Activity getById(UUID id);

    List<Activity> getAll();

    Activity update(UUID id, ActivityRequest request);

    void delete(UUID id);
}

