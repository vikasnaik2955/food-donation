package com.dfs.donor_food_serivce.dto;


import com.dfs.donor_food_serivce.enums.ConsumerType;
import lombok.Data;

import java.util.UUID;

@Data
public class ConsumerResponse {

    private UUID id;
    private String name;
    private ConsumerType type;
    private String location;
    private Integer noOfPeople;
    private String contact;
    private String email;
    private boolean active;
}
