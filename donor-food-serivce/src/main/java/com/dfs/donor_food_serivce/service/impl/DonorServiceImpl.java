package com.dfs.donor_food_serivce.service.impl;

import com.dfs.donor_food_serivce.dto.DonorRequest;
import com.dfs.donor_food_serivce.dto.DonorResponseDTO;
import com.dfs.donor_food_serivce.entity.Donor;
import com.dfs.donor_food_serivce.mapper.DonorMapper;
import com.dfs.donor_food_serivce.repository.DonorRepository;
import com.dfs.donor_food_serivce.service.DonorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }



    @Override
    public DonorResponseDTO createDonor(DonorRequest request) {
        Donor donor = Donor.builder()
                .name(request.getName())
                .contact(request.getContact())
                .email(request.getEmail())
                .location(request.getLocation())
                .types(request.getType())
                .totalRewards(0)
                .build();

        donor = donorRepository.save(donor);
        return toResponse(donor);
    }

    @Override
    public DonorResponseDTO getDonor(String id) {

        Donor donor = donorRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("Donor not found: " + id));
        return toResponse(donor);
    }

    @Override
    public List<DonorResponseDTO> getAllDonors() {
        List<Donor> donors = donorRepository.findAll();

        return donors.stream()
                .map(DonorMapper::toDTO).toList();
    }

    private DonorResponseDTO toResponse(Donor donor) {

            DonorResponseDTO res = new DonorResponseDTO();
            res.setId(donor.getId());
            res.setName(donor.getName());
            res.setContact(donor.getContact());
            res.setEmail(donor.getEmail());
            res.setLocation(donor.getLocation());
            res.setType(donor.getTypes());
            res.setTotalRewards(donor.getTotalRewards());
            res.setStatus(donor.getStatus());
            return res;
        }
    }
