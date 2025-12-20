package com.logistics_service.logistics_service.controller;


import com.logistics_service.logistics_service.dto.VolunteerRequest;
import com.logistics_service.logistics_service.dto.VolunteerResponse;
import com.logistics_service.logistics_service.service.VolunteerService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<VolunteerResponse> create(
            @Valid @RequestBody VolunteerRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    // READ by ID
    @GetMapping("/{id}")
    public VolunteerResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    // READ all
    @GetMapping
    public List<VolunteerResponse> getAll() {
        return service.getAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public VolunteerResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody VolunteerRequest request) {
        return service.update(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

