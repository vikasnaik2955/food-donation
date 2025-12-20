package com.logistics_service.logistics_service.repository;




import com.logistics_service.logistics_service.entity.Volunteer;
import com.logistics_service.logistics_service.enums.VolunteerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VolunteerRepository extends JpaRepository<Volunteer, UUID> {

    List<Volunteer> findByLocationAndStatus(String location, VolunteerStatus status);
}

