package com.dfs.donor_food_serivce.service;


import com.dfs.donor_food_serivce.dto.DonorRequest;
import com.dfs.donor_food_serivce.dto.DonorResponseDTO;

import java.util.List;

public interface DonorService {

    DonorResponseDTO createDonor(DonorRequest request);

    public DonorResponseDTO getDonor(String id);

    List<DonorResponseDTO> getAllDonors();
}
