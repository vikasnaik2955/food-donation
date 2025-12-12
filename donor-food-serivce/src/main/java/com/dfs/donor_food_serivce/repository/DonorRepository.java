package com.dfs.donor_food_serivce.repository;

import com.dfs.donor_food_serivce.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DonorRepository extends JpaRepository<Donor, UUID> {
}
