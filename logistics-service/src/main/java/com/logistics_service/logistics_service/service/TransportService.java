package com.logistics_service.logistics_service.service;


import com.logistics_service.logistics_service.dto.TransportRequest;
import com.logistics_service.logistics_service.dto.TransportResponse;
import com.logistics_service.logistics_service.enums.TransportStatus;

import java.util.List;
import java.util.UUID;

public interface TransportService {

    TransportResponse create(TransportRequest request);

    TransportResponse getById(UUID id);

    List<TransportResponse> getAll(String location, TransportStatus status);

    TransportResponse update(UUID id, TransportRequest request);

    void updateStatus(UUID id, TransportStatus status);

    void delete(UUID id);
}

