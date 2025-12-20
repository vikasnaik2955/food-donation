package com.logistics_service.logistics_service.dto;


import com.logistics_service.logistics_service.enums.TransportType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransportRequest {

    @NotNull
    private TransportType type;

    @NotBlank
    private String location;

    private String vehicleNumber;
    private String driverName;
    private String contact;

    public TransportType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getContact() {
        return contact;
    }
}

