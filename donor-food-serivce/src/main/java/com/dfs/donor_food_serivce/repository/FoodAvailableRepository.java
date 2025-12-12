package com.dfs.donor_food_serivce.repository;

import com.dfs.donor_food_serivce.entity.FoodAvailable;
import com.dfs.donor_food_serivce.enums.AllocationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FoodAvailableRepository extends JpaRepository<FoodAvailable, UUID> {

    List<FoodAvailable> findByDonorId(UUID donorId);

    List<FoodAvailable> findByStatus(AllocationStatus status);
}
