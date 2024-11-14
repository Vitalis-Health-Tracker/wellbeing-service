package com.example.wellbeing_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "wellbeing")
public class WellbeingModel {
    @Id
    private String wellbeingId;
    private String userId;
    private Integer sleepTime;
    private String mood;
    private LocalDateTime wellbeingDate;
}
