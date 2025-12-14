package com.dfs.donor_food_serivce.controller;


import com.dfs.donor_food_serivce.dto.DonorRequest;
import com.dfs.donor_food_serivce.dto.DonorResponseDTO;
import com.dfs.donor_food_serivce.entity.Donor;
import com.dfs.donor_food_serivce.entity.FoodAvailable;
import com.dfs.donor_food_serivce.service.DonorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Donor API", description = "Operations related to Donors")
@RestController
@RequestMapping("/donor")
public class DonorHomeClass {


    private final DonorService donorService;

    public DonorHomeClass(DonorService donorService) {
        this.donorService = donorService;
    }



//    @GetMapping
//    public String welcome(){
//
//        return "Welcome";
//    }

//    @GetMapping("/Food")
//    public String Donation(@RequestParam String foodNmae, int id,String Food_Allocation){
//
//        return "Food Donation "+foodNmae+"---"+id+"----"+Food_Allocation;
//    }

    @Operation(summary = "Create a new donor")
    @PostMapping
    public ResponseEntity<DonorResponseDTO> createDonor(
            @Valid @RequestBody DonorRequest request) {
        return new ResponseEntity<>(donorService.createDonor(request), HttpStatus.CREATED);
    }

    public ResponseEntity<Donor> updateDonor(){
        return null;
    }

    @Operation(summary = "Get All Donor")
    @GetMapping
    public ResponseEntity<List<DonorResponseDTO>> getAllDonors(){

        return new ResponseEntity<List<DonorResponseDTO>>(donorService.getAllDonors(), HttpStatus.OK);
    }

    @Operation(summary = "Get donor by their Id")
    @GetMapping("/{id}")
    public DonorResponseDTO getDonor(@PathVariable String id) {
        return donorService.getDonor(id);
    }

    public void deleteDonorById(){

    }

    // ✅ UPDATE
    @Operation(summary = "Update donor by their Id")
    @PutMapping("/{id}")
    public ResponseEntity<DonorResponseDTO> updateDonor(
            @PathVariable UUID id,
            @Valid @RequestBody DonorRequest request) {

        return ResponseEntity.ok(donorService.updateDonor(id, request));
    }

    @Operation(summary = "Delete donor by ID (Soft Delete)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable UUID id) {

        donorService.deleteDonor(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
