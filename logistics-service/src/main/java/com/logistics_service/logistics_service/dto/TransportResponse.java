package com.logistics_service.logistics_service.dto;


import com.logistics_service.logistics_service.enums.TransportStatus;
import com.logistics_service.logistics_service.enums.TransportType;
import lombok.Data;

import java.util.UUID;

@Data
public class TransportResponse {

    private UUID id;
    private TransportType type;
    private String location;
    private TransportStatus status;
    private String vehicleNumber;
    private String driverName;
    private String contact;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(TransportStatus status) {
        this.status = status;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

