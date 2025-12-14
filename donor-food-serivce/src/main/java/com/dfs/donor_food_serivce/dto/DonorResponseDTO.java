package com.dfs.donor_food_serivce.dto;


import com.dfs.donor_food_serivce.enums.DonorStatus;
import com.dfs.donor_food_serivce.enums.DonorType;
import lombok.Data;

import java.util.UUID;

@Data
public class DonorResponseDTO {

    private String id;
    private String name;
    private String contact;
    private String email;
    private String location;
    private DonorType type;
    private Integer totalRewards;
    private DonorStatus status;

}
