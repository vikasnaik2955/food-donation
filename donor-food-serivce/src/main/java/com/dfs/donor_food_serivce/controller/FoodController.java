package com.dfs.donor_food_serivce.controller;

import com.dfs.donor_food_serivce.dto.FoodAvailableRequestDTO;
import com.dfs.donor_food_serivce.dto.FoodAvailableResponse;
import com.dfs.donor_food_serivce.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // ✅ CREATE FOOD
    @PostMapping
    public ResponseEntity<FoodAvailableResponse> createFood(
            @Valid @RequestBody FoodAvailableRequestDTO request) {

        return new ResponseEntity<>(
                foodService.createFoodRequest(request),
                HttpStatus.CREATED
        );
    }

    // ✅ GET FOOD BY ID
    @GetMapping("/{id}")
    public ResponseEntity<FoodAvailableResponse> getFood(@PathVariable UUID id) {

        return ResponseEntity.ok(foodService.getFood(id));
    }

    // ✅ GET FOOD BY DONOR
    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<FoodAvailableResponse>> getFoodByDonor(
            @PathVariable UUID donorId) {

        return ResponseEntity.ok(foodService.getFoodByDonor(donorId));
    }
    // ✅ UPDATE FOOD
    @PutMapping("/{id}")
    public ResponseEntity<FoodAvailableResponse> updateFood(
            @PathVariable UUID id,
            @Valid @RequestBody FoodAvailableRequestDTO request) {

        return ResponseEntity.ok(foodService.updateFood(id, request));
    }
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelFood(@PathVariable UUID id) {

        foodService.cancelFood(id);
        return ResponseEntity.noContent().build();
    }
    // ✅ GET ALL AVAILABLE FOOD
    @GetMapping
    public ResponseEntity<List<FoodAvailableResponse>> getAllFood() {

        return ResponseEntity.ok(foodService.getAllAvailableFood());
    }

}
