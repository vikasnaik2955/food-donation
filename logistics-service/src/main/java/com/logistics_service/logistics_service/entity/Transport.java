package com.logistics_service.logistics_service.entity;


import com.logistics_service.logistics_service.enums.TransportStatus;
import com.logistics_service.logistics_service.enums.TransportType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transports")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Transport extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransportType type;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    private TransportStatus status = TransportStatus.AVAILABLE;

    // Optional details
    private String vehicleNumber;
    private String driverName;
    private String contact;

    public Transport() {
    }

    private Transport(Builder builder) {
        this.type = builder.type;
        this.location = builder.location;
        this.status = builder.status != null ? builder.status : TransportStatus.AVAILABLE;
        this.vehicleNumber = builder.vehicleNumber;
        this.driverName = builder.driverName;
        this.contact = builder.contact;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private TransportType type;
        private String location;
        private TransportStatus status;
        private String vehicleNumber;
        private String driverName;
        private String contact;

        private Builder() {
        }

        public Builder type(TransportType type) {
            this.type = type;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder status(TransportStatus status) {
            this.status = status;
            return this;
        }

        public Builder vehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public Builder driverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public Transport build() {
            if (type == null) {
                throw new IllegalStateException("Transport type is required");
            }
            if (location == null || location.isBlank()) {
                throw new IllegalStateException("Location is required");
            }
            return new Transport(this);
        }
    }

    public TransportType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public TransportStatus getStatus() {
        return status;
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

