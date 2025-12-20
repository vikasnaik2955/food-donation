package com.logistics_service.logistics_service.repository;


import com.logistics_service.logistics_service.entity.Transport;
import com.logistics_service.logistics_service.enums.TransportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransportRepository extends JpaRepository<Transport, UUID> {

    List<Transport> findByLocationIgnoreCaseAndStatus(String location, TransportStatus status);

    List<Transport> findByLocationIgnoreCase(String location);

    List<Transport> findByStatus(TransportStatus status);
}

