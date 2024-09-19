package com.example.profileme_service.repository;

import com.example.profileme_service.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    List<ProfileEntity> findByNameContainingIgnoreCase(String name);
}