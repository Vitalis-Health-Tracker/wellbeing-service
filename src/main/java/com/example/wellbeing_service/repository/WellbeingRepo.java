package com.example.wellbeing_service.repository;

import com.example.wellbeing_service.model.WellbeingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WellbeingRepo extends MongoRepository<WellbeingModel, String> {
    public List<WellbeingModel> findByUserIdAndWellbeingDateBetween(String userId, String startDate, String endDate);
}
