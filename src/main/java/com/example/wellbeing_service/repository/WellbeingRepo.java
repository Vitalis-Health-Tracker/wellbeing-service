package com.example.wellbeing_service.repository;

import com.example.wellbeing_service.model.WellbeingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface WellbeingRepo extends MongoRepository<WellbeingModel, String> {
    public Optional<List<WellbeingModel>> findByUserIdAndWellbeingDateBetween(String userId, LocalDateTime startDate, LocalDateTime endDate);
}
