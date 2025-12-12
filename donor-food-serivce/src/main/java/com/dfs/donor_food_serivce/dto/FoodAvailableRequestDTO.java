package com.dfs.donor_food_serivce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class FoodAvailableRequestDTO {

    @NotNull
    private UUID donorId;

    @NotBlank
    private String description;

    @Min(1)
    private Integer noOfPeople;

    @NotBlank
    private String location;

    private LocalDateTime preparedAt;
    private LocalDateTime expiryAt;
    private String evidenceUrl;
}
