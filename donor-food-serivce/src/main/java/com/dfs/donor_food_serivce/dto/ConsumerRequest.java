package com.dfs.donor_food_serivce.dto;


import com.dfs.donor_food_serivce.enums.ConsumerType;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ConsumerRequest {

    @NotBlank
    private String name;

    @NotNull
    private ConsumerType type;

    @NotBlank
    private String location;

    @Min(1)
    private Integer noOfPeople;

    private String contact;

    @Email
    private String email;
}
