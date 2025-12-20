package com.dfs.donor_food_serivce.service;

import com.dfs.donor_food_serivce.dto.ConsumerRequest;
import com.dfs.donor_food_serivce.dto.ConsumerResponse;

import java.util.List;
import java.util.UUID;

public interface ConsumerService {

    ConsumerResponse createConsumer(ConsumerRequest request);

    ConsumerResponse getConsumer(UUID id);

    List<ConsumerResponse> getAllConsumers(String location);
}
