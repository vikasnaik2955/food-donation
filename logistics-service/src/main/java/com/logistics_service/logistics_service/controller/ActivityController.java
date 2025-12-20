package com.logistics_service.logistics_service.controller;

import com.logistics_service.logistics_service.dto.ActivityRequest;
import com.logistics_service.logistics_service.entity.Activity;
import com.logistics_service.logistics_service.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @PostMapping
    public Activity create(@RequestBody ActivityRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public Activity getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Activity> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Activity update(@PathVariable UUID id,
                           @RequestBody ActivityRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

