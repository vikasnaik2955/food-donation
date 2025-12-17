package com.dfs.donor_food_serivce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Request payload for creating donor food donation")
public class DonorFoodRequest {

    @Schema(description = "Donor ID", example = "b3a7f2b4-4f9e-4c0d-b7c5-1f92c3e7dabc")
    @NotNull(message = "Donor ID is required")
    private UUID donorId;

    @Schema(description = "Type of food", example = "Cooked / Packed")
    @NotBlank(message = "Food type is required")
    private String foodType;

    @Schema(description = "Food description", example = "Rice, Dal, Chapati")
    @NotBlank(message = "Food description is required")
    private String description;

    @Schema(description = "Number of people food can serve", example = "25")
    @Positive(message = "Quantity must be greater than zero")
    private int quantity;

    @Schema(description = "Food expiry date & time", example = "2025-12-14T18:30:00")
    @NotNull(message = "Expiry time is required")
    private LocalDateTime expiryTime;

    @Schema(description = "Pickup location", example = "Pune Hadapsar")
    @NotBlank(message = "Pickup location is required")
    private String pickupLocation;

    // getters & setters
    public UUID getDonorId() {
        return donorId;
    }

    public void setDonorId(UUID donorId) {
        this.donorId = donorId;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
}
