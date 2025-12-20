package com.dfs.donor_food_serivce.service.impl;

import com.dfs.donor_food_serivce.dto.ConsumerRequest;
import com.dfs.donor_food_serivce.dto.ConsumerResponse;
import com.dfs.donor_food_serivce.entity.Consumer;
import com.dfs.donor_food_serivce.repository.ConsumerRepository;
import com.dfs.donor_food_serivce.service.ConsumerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerRepository repository;

    public ConsumerServiceImpl(ConsumerRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsumerResponse createConsumer(ConsumerRequest request) {
        Consumer consumer = Consumer.builder()
                .name(request.getName())
                .type(request.getType())
                .location(request.getLocation())
                .noOfPeople(request.getNoOfPeople())
                .contact(request.getContact())
                .email(request.getEmail())
                .build();

        return map(repository.save(consumer));
    }

    @Override
    public ConsumerResponse getConsumer(UUID id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consumer not found")));
    }

    @Override
    public List<ConsumerResponse> getAllConsumers(String location) {
        List<Consumer> consumers =
                (location == null)
                        ? repository.findAll()
                        : repository.findByLocationIgnoreCase(location);

        return consumers.stream().map(this::map).toList();
    }

    private ConsumerResponse map(Consumer c) {
        ConsumerResponse res = new ConsumerResponse();
        res.setId(c.getId());
        res.setName(c.getName());
        res.setType(c.getType());
        res.setLocation(c.getLocation());
        res.setNoOfPeople(c.getNoOfPeople());
        res.setContact(c.getContact());
        res.setEmail(c.getEmail());
        res.setActive(c.isActive());
        return res;
    }
}
