package com.dfs.donor_food_serivce.service.impl;

import com.dfs.donor_food_serivce.dto.FoodAvailableRequestDTO;
import com.dfs.donor_food_serivce.dto.FoodAvailableResponse;
import com.dfs.donor_food_serivce.entity.FoodAvailable;
import com.dfs.donor_food_serivce.repository.FoodAvailableRepository;
import com.dfs.donor_food_serivce.service.FoodService;

import java.util.List;
import java.util.UUID;

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
                .location(request.getLocation())
                .preparedAt(request.getPreparedAt())
                .expiryAt(request.getExpiryAt())
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
        res.setLocation(fa.getLocation());
        res.setStatus(fa.getStatus());
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
}
