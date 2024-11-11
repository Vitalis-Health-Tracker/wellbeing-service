package com.example.wellbeing_service.controller;

import com.example.wellbeing_service.model.WellbeingModel;
import com.example.wellbeing_service.service.WellbeingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wellbeing")
public class WellbeingController {

    @Autowired
    private WellbeingService wellbeingService;

    @PostMapping
    public String saveWellbeing(@RequestBody WellbeingModel wellbeingModel, @RequestParam String userId) {
        wellbeingModel.setUserId(userId);
        return wellbeingService.saveWellbeing(wellbeingModel);
    }

    @GetMapping("/{id}")
    public WellbeingModel getWellbeing(@PathVariable String wellbeingId) {
        return wellbeingService.getWellbeing(wellbeingId);
    }

    @DeleteMapping("/{id}")
    public String deleteWellbeing(@PathVariable String wellbeingId) {
        return wellbeingService.deleteWellbeing(wellbeingId);
    }

    @GetMapping("/date")
    public Iterable<WellbeingModel> getWellbeingByDate(@RequestParam String userId, @RequestParam String startDate, @RequestParam String endDate) {
        return wellbeingService.getWellbeingByDate(userId,startDate, endDate);
    }

}
