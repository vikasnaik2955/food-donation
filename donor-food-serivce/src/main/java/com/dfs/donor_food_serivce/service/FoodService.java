package com.dfs.donor_food_serivce.service;

import com.dfs.donor_food_serivce.dto.FoodAvailableRequestDTO;
import com.dfs.donor_food_serivce.dto.FoodAvailableResponse;

import java.util.List;
import java.util.UUID;


public interface FoodService {

    FoodAvailableResponse createFoodRequest(FoodAvailableRequestDTO request);

    List<FoodAvailableResponse> getFoodByDonor(UUID donorId);

    FoodAvailableResponse getFood(UUID id);

    FoodAvailableResponse updateFood(UUID foodId, FoodAvailableRequestDTO request);

    void cancelFood(UUID foodId);
    
    List<FoodAvailableResponse> getAllAvailableFood();

}
