package com.dfs.donor_food_serivce.controller;

import com.dfs.donor_food_serivce.dto.ConsumerRequest;
import com.dfs.donor_food_serivce.dto.ConsumerResponse;
import com.dfs.donor_food_serivce.service.ConsumerService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final ConsumerService service;

    public ConsumerController(ConsumerService service) {
        this.service = service;
    }

    // ✅ POST /consumer
    @PostMapping
    public ResponseEntity<ConsumerResponse> createConsumer(
            @Valid @RequestBody ConsumerRequest request) {

        return new ResponseEntity<>(service.createConsumer(request), HttpStatus.CREATED);
    }

    // ✅ GET /consumer/{id}
    @GetMapping("/{id}")
    public ConsumerResponse getConsumer(@PathVariable UUID id) {
        return service.getConsumer(id);
    }

    // ✅ GET /consumer?location=Pune
    @GetMapping
    public List<ConsumerResponse> getConsumers(
            @RequestParam(required = false) String location) {

        return service.getAllConsumers(location);
    }

//    @GetMapping("/{id}/history")
//    public Object getConsumerHistory(@PathVariable UUID id) {
//        return allocationClient.getConsumerHistory(id);
//    }


}
