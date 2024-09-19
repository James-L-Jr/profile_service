package com.example.profileme_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profileme_service.model.FeedbackEntity;
import com.example.profileme_service.repository.FeedbackRepository;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping
    public ResponseEntity<FeedbackEntity> submitFeedback(@RequestBody FeedbackEntity feedback) {
        FeedbackEntity savedFeedback = feedbackRepository.save(feedback);
        return ResponseEntity.ok(savedFeedback);
    }
}