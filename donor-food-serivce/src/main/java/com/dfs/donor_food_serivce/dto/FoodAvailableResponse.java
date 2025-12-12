package com.dfs.donor_food_serivce.dto;


import com.dfs.donor_food_serivce.enums.AllocationStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FoodAvailableResponse {

    private UUID id;
    private UUID donorId;
    private String description;
    private Integer noOfPeople;
    private String location;
    private AllocationStatus status;
    private LocalDateTime createdAt;
}
