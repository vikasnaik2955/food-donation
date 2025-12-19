package com.dfs.donor_food_serivce.entity;

import com.dfs.donor_food_serivce.enums.AllocationStatus;
import com.dfs.donor_food_serivce.enums.FoodAvailableStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "food_available")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodAvailable extends BaseEntity {

    @Column(nullable = false, columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID donorId;

//    @Column(nullable = false)
//    private String foodType;

    @Column(nullable = false)
    private String description;

    /**
     * Quantity of food items (optional)
     */
    @Column(nullable = false)
    private int quantity;

    /**
     * Number of people this food can serve
     */
    @Column(name = "no_of_people", nullable = false)
    private int noOfPeople;

    @Column(name = "prepared_at", nullable = false)
    private LocalDateTime preparedAt;

    @Column(nullable = false)
    private LocalDateTime expiryTime;

    @Column(name = "evidence_url")
    private String evidenceURL;

    /**
     * Exact pickup address
     */
    @Column(nullable = false)
    private String pickupLocation;

    /**
     * Food availability lifecycle
     */
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private FoodAvailableStatus status = FoodAvailableStatus.AVAILABLE;

    /**
     * Allocation lifecycle status
     */
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private AllocationStatus allocationStatus = AllocationStatus.REQUESTED;
}
