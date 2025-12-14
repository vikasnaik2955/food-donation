package com.dfs.donor_food_serivce.dto;

import com.dfs.donor_food_serivce.enums.DonorStatus;
import com.dfs.donor_food_serivce.enums.DonorType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DonorRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    @Email
    private String email;

    @NotBlank
    private String location;

    private DonorType type;

    private DonorStatus status;
}
