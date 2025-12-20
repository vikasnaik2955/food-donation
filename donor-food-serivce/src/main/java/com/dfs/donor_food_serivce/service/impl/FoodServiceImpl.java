package com.dfs.donor_food_serivce.service.impl;

import com.dfs.donor_food_serivce.dto.FoodAvailableRequestDTO;
import com.dfs.donor_food_serivce.dto.FoodAvailableResponse;
import com.dfs.donor_food_serivce.entity.FoodAvailable;
import com.dfs.donor_food_serivce.enums.AllocationStatus;
import com.dfs.donor_food_serivce.enums.FoodAvailableStatus;
import com.dfs.donor_food_serivce.repository.FoodAvailableRepository;
import com.dfs.donor_food_serivce.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodAvailableRepository foodRepo;

    public FoodServiceImpl(FoodAvailableRepository foodRepo) {
        this.foodRepo = foodRepo;
    }
    @Override
    public FoodAvailableResponse createFoodRequest(FoodAvailableRequestDTO request) {
        FoodAvailable fa = FoodAvailable.builder()
                .donorId(request.getDonorId())
                .description(request.getDescription())
                .noOfPeople(request.getNoOfPeople())
                .pickupLocation(request.getLocation())
                .preparedAt(request.getPreparedAt())
                .expiryTime(request.getExpiryAt())
                .evidenceURL(request.getEvidenceUrl())
                .build();

        fa = foodRepo.save(fa);
        return toResponse(fa);
    }

    private FoodAvailableResponse toResponse(FoodAvailable fa) {
        FoodAvailableResponse res = new FoodAvailableResponse();
        res.setId(fa.getId());
        res.setDonorId(fa.getDonorId());
        res.setDescription(fa.getDescription());
        res.setNoOfPeople(fa.getNoOfPeople());
        res.setLocation(fa.getPickupLocation());
        res.setFoodAvailableStatus(fa.getStatus());
        res.setStatus(fa.getAllocationStatus());
        res.setCreatedAt(fa.getCreatedAt());
        return res;

    }

    @Override
    public List<FoodAvailableResponse> getFoodByDonor(UUID donorId) {
        return foodRepo.findByDonorId(donorId).stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public FoodAvailableResponse getFood(UUID id) {
        FoodAvailable fa = foodRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Food not found: " + id));
        return toResponse(fa);
    }

    @Override
    public FoodAvailableResponse updateFood(UUID foodId, FoodAvailableRequestDTO request) {

        FoodAvailable food = foodRepo.findById(foodId)
                .orElseThrow(() -> new IllegalArgumentException("Food not found"));

        // ❌ Do not allow update if already allocated or cancelled
        if (food.getAllocationStatus() != AllocationStatus.REQUESTED ||
                food.getStatus() != FoodAvailableStatus.AVAILABLE) {
            throw new IllegalStateException("Food cannot be updated at this stage");
        }

        food.setDescription(request.getDescription());
        food.setNoOfPeople(request.getNoOfPeople());
        food.setPreparedAt(request.getPreparedAt());
        food.setExpiryTime(request.getExpiryAt());
        food.setPickupLocation(request.getLocation());
        food.setEvidenceURL(request.getEvidenceUrl());

        return toResponse(foodRepo.save(food));
    }

    @Override
    public void cancelFood(UUID foodId) {

        FoodAvailable food = foodRepo.findById(foodId)
                .orElseThrow(() -> new IllegalArgumentException("Food not found"));

        // If already cancelled, do nothing
        if (food.getStatus() == FoodAvailableStatus.CANCELLED) {
            return;
        }

        food.setStatus(FoodAvailableStatus.CANCELLED);
        food.setAllocationStatus(AllocationStatus.CANCELLED);

        foodRepo.save(food);
    }

    @Override
    public List<FoodAvailableResponse> getAllAvailableFood() {

        return foodRepo.findByStatus(FoodAvailableStatus.AVAILABLE)
                .stream()
                .map(this::toResponse)
                .toList();
    }


}
