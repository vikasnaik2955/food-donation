package com.dfs.donor_food_serivce.entity;

import com.dfs.donor_food_serivce.enums.ConsumerType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "consumers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consumer extends BaseEntity {

    @Column(nullable = false)
    private String name;

    // NGO / SLUM / OLD_AGE_HOME / SHELTER
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsumerType type;

    @Column(nullable = false)
    private String location;

    @Column(name = "no_of_people", nullable = false)
    private Integer noOfPeople;

    private String contact;

    private String email;

    @Builder.Default
    private boolean active = true;
}
