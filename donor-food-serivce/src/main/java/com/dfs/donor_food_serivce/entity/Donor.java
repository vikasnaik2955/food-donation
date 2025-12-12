package com.dfs.donor_food_serivce.entity;


import com.dfs.donor_food_serivce.enums.DonorStatus;
import com.dfs.donor_food_serivce.enums.DonorType;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "donors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donor extends BaseEntity{


    private String name;

    private String contact;

    private String email;

    private String location;

    @Enumerated(EnumType.STRING)
    private DonorType types;

    private int totalRewards;

    @Enumerated(EnumType.STRING)
    private DonorStatus status = DonorStatus.ACTIVE;

//    @OneToMany(mappedBy = "donor")
//    private List<FoodAvailable> foodAvailableList;
}
