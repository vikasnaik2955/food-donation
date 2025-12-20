package com.logistics_service.logistics_service.service.impl;


import com.logistics_service.logistics_service.dto.VolunteerRequest;
import com.logistics_service.logistics_service.dto.VolunteerResponse;
import com.logistics_service.logistics_service.entity.Volunteer;
import com.logistics_service.logistics_service.repository.VolunteerRepository;
import com.logistics_service.logistics_service.service.VolunteerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository repository;

    public VolunteerServiceImpl(VolunteerRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerResponse create(VolunteerRequest request) {
        Volunteer volunteer = Volunteer.builder()
                .name(request.getName())
                .contact(request.getContact())
                .email(request.getEmail())
                .location(request.getLocation())
                .qualification(request.getQualification())
                .build();

        return mapToResponse(repository.save(volunteer));
    }

    @Override
    public VolunteerResponse getById(UUID id) {
        return mapToResponse(findVolunteer(id));
    }

    @Override
    public List<VolunteerResponse> getAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public VolunteerResponse update(UUID id, VolunteerRequest request) {
        Volunteer volunteer = findVolunteer(id);

        volunteer.setName(request.getName());
        volunteer.setContact(request.getContact());
        volunteer.setEmail(request.getEmail());
        volunteer.setLocation(request.getLocation());
        volunteer.setQualification(request.getQualification());

        return mapToResponse(repository.save(volunteer));
    }

    @Override
    public void delete(UUID id) {
        repository.delete(findVolunteer(id));
    }

    private Volunteer findVolunteer(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Volunteer not found: " + id));
    }

    private VolunteerResponse mapToResponse(Volunteer v) {
        VolunteerResponse res = new VolunteerResponse();
        res.setId(v.getId());
        res.setName(v.getName());
        res.setContact(v.getContact());
        res.setEmail(v.getEmail());
        res.setLocation(v.getLocation());
        res.setQualification(v.getQualification());
        res.setStatus(v.getStatus());
        return res;
    }
}

