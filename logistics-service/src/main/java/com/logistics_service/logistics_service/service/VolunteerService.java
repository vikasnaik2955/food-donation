package com.logistics_service.logistics_service.service;


import com.logistics_service.logistics_service.dto.VolunteerRequest;
import com.logistics_service.logistics_service.dto.VolunteerResponse;

import java.util.List;
import java.util.UUID;

public interface VolunteerService {

    VolunteerResponse create(VolunteerRequest request);

    VolunteerResponse getById(UUID id);

    List<VolunteerResponse> getAll();

    VolunteerResponse update(UUID id, VolunteerRequest request);

    void delete(UUID id);
}

