package com.logistics_service.logistics_service.controller;


import com.logistics_service.logistics_service.dto.TransportRequest;
import com.logistics_service.logistics_service.dto.TransportResponse;
import com.logistics_service.logistics_service.enums.TransportStatus;
import com.logistics_service.logistics_service.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transports")
public class TransportController {

    private final TransportService service;

    public TransportController(TransportService service) {
        this.service = service;
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<TransportResponse> create(
            @Valid @RequestBody TransportRequest request) {

        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public TransportResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    // ✅ GET ALL / FILTER
    // /transports?location=PUNE&status=AVAILABLE
    @GetMapping
    public List<TransportResponse> getAll(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) TransportStatus status) {

        return service.getAll(location, status);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public TransportResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody TransportRequest request) {

        return service.update(id, request);
    }

    // ✅ UPDATE STATUS
    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable UUID id,
            @RequestParam TransportStatus status) {

        service.updateStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

