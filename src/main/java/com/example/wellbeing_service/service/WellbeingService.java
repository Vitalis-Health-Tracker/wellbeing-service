package com.example.wellbeing_service.service;

import com.example.wellbeing_service.model.WellbeingModel;
import com.example.wellbeing_service.repository.WellbeingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WellbeingService {

    @Autowired
    private WellbeingRepo wellbeingRepo;

    public String saveWellbeing(WellbeingModel wellbeingModel) {
        wellbeingRepo.save(wellbeingModel);
        return "Wellbeing saved";
    }

    public WellbeingModel getWellbeing(String wellbeingId) {
        return wellbeingRepo.findById(wellbeingId).orElse(null);
    }

    public String deleteWellbeing(String wellbeingId) {
        wellbeingRepo.deleteById(wellbeingId);
        return "Wellbeing deleted";
    }

    public List<WellbeingModel> getWellbeingByDate(String startDate, String endDate) {
        return wellbeingRepo.findByWellbeingDateBetween(startDate, endDate);
    }
}
