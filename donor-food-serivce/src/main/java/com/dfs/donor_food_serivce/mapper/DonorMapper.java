package com.dfs.donor_food_serivce.mapper;

import com.dfs.donor_food_serivce.dto.DonorResponseDTO;
import com.dfs.donor_food_serivce.entity.Donor;

public class DonorMapper {

    public static DonorResponseDTO toDTO(Donor donor){
        DonorResponseDTO donorResponseDTO = new DonorResponseDTO();

        donorResponseDTO.setEmail(donor.getEmail());
        donorResponseDTO.setId(donor.getId().toString());
        donorResponseDTO.setLocation(donor.getLocation());
        donorResponseDTO.setContact(donor.getContact());
        donorResponseDTO.setName(donor.getName());
        donorResponseDTO.setStatus(donor.getStatus());
        donorResponseDTO.setTotalRewards(donor.getTotalRewards());
        donorResponseDTO.setType(donor.getType());
     return donorResponseDTO;
    }
}
