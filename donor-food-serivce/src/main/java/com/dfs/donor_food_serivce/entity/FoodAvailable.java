package com.dfs.donor_food_serivce.entity;


import com.dfs.donor_food_serivce.enums.AllocationStatus;
import com.dfs.donor_food_serivce.enums.FoodAvailableStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "food_available")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodAvailable extends BaseEntity{


    @Column(name = "donor_id", nullable = false)
    private UUID donorId;

    private String description;

    @Column(name = "no_of_people")
    private int noOfPeople;

    private String location;

    private LocalDateTime preparedAt;

    private LocalDateTime expiryAt;

    @Enumerated(EnumType.STRING)
    private AllocationStatus status = AllocationStatus.REQUESTED;

    private String evidenceURL;

}
