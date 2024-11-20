package com.example.wellbeing_service.service;

import com.example.wellbeing_service.model.WellbeingModel;
import com.example.wellbeing_service.repository.WellbeingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WellbeingService {

    @Autowired
    private WellbeingRepo wellbeingRepo;

    public String saveWellbeing(WellbeingModel wellbeingModel) {
        if(wellbeingRepo.findByUserIdAndWellbeingDateBetween(wellbeingModel.getUserId(), LocalDateTime.now().toLocalDate().atStartOfDay(), LocalDateTime.now()) != null)
        {
            return updateWellbeing(wellbeingModel);
        }
        else
        {
            wellbeingModel.setWellbeingDate(LocalDateTime.now());
            wellbeingRepo.save(wellbeingModel);
            return "Wellbeing saved";
        }
    }

    public String deleteWellbeing(String wellbeingId) {
        wellbeingRepo.deleteById(wellbeingId);
        return "Wellbeing deleted";
    }

    public List<WellbeingModel> getWellbeingByDate(String userId, LocalDateTime startDate, LocalDateTime endDate) {
        return wellbeingRepo.findAllByUserIdAndWellbeingDateBetween(userId,startDate, endDate)
                .orElseThrow(() -> new RuntimeException("Record not Found!!"));
    }

    public WellbeingModel getWellbeing(String userId)
    {
        return wellbeingRepo.findByUserIdAndWellbeingDateBetween(userId, LocalDateTime.now().toLocalDate().atStartOfDay(), LocalDateTime.now());
    }

    public String updateWellbeing(WellbeingModel wellbeingModel) {
        WellbeingModel oldWellbeing = wellbeingRepo.findByUserIdAndWellbeingDateBetween(wellbeingModel.getUserId(), LocalDateTime.now().toLocalDate().atStartOfDay(), LocalDateTime.now());
        oldWellbeing.setSleepTime(wellbeingModel.getSleepTime());
        oldWellbeing.setMood(wellbeingModel.getMood());
        wellbeingRepo.save(oldWellbeing);
        return "Wellbeing updated";
    }
}
