package com.logistics_service.logistics_service.service.impl;


import com.logistics_service.logistics_service.dto.TransportRequest;
import com.logistics_service.logistics_service.dto.TransportResponse;
import com.logistics_service.logistics_service.entity.Transport;
import com.logistics_service.logistics_service.enums.TransportStatus;
import com.logistics_service.logistics_service.repository.TransportRepository;
import com.logistics_service.logistics_service.service.TransportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransportServiceImpl implements TransportService {

    private final TransportRepository repository;

    public TransportServiceImpl(TransportRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransportResponse create(TransportRequest request) {
        Transport transport = Transport.builder()
                .type(request.getType())
                .location(request.getLocation())
                .vehicleNumber(request.getVehicleNumber())
                .driverName(request.getDriverName())
                .contact(request.getContact())
                .build();

        return map(repository.save(transport));
    }

    @Override
    public TransportResponse getById(UUID id) {
        return map(find(id));
    }

    @Override
    public List<TransportResponse> getAll(String location, TransportStatus status) {

        List<Transport> transports;

        if (location != null && status != null) {
            transports = repository.findByLocationIgnoreCaseAndStatus(location, status);
        } else if (location != null) {
            transports = repository.findByLocationIgnoreCase(location);
        } else if (status != null) {
            transports = repository.findByStatus(status);
        } else {
            transports = repository.findAll();
        }

        return transports.stream().map(this::map).toList();
    }

    @Override
    public TransportResponse update(UUID id, TransportRequest request) {
        Transport transport = find(id);

        transport.setType(request.getType());
        transport.setLocation(request.getLocation());
        transport.setVehicleNumber(request.getVehicleNumber());
        transport.setDriverName(request.getDriverName());
        transport.setContact(request.getContact());

        return map(repository.save(transport));
    }

    @Override
    public void updateStatus(UUID id, TransportStatus status) {
        Transport transport = find(id);
        transport.setStatus(status);
        repository.save(transport);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(find(id));
    }

    private Transport find(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transport not found"));
    }

    private TransportResponse map(Transport t) {
        TransportResponse res = new TransportResponse();
        res.setId(t.getId());
        res.setType(t.getType());
        res.setLocation(t.getLocation());
        res.setStatus(t.getStatus());
        res.setVehicleNumber(t.getVehicleNumber());
        res.setDriverName(t.getDriverName());
        res.setContact(t.getContact());
        return res;
    }
}

