package com.example.profileme_service.repository;
import com.example.profileme_service.model.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
    
}