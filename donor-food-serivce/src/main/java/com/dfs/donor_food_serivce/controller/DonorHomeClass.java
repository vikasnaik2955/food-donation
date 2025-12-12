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

    @PostMapping
    public ResponseEntity<DonorResponseDTO> createDonor(
            @Valid @RequestBody DonorRequest request) {
        return new ResponseEntity<>(donorService.createDonor(request), HttpStatus.CREATED);
    }

    public ResponseEntity<Donor> updateDonor(){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<DonorResponseDTO>> getAllDonors(){

        return new ResponseEntity<List<DonorResponseDTO>>(donorService.getAllDonors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DonorResponseDTO getDonor(@PathVariable String id) {
        return donorService.getDonor(id);
    }

    public void deleteDonorById(){

    }
}
