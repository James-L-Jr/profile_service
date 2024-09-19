package com.example.profileme_service.service;

import com.example.profileme_service.model.ProfileEntity;
import com.example.profileme_service.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<ProfileEntity> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<ProfileEntity> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public List<ProfileEntity> searchProfiles(String name) {
        return profileRepository.findByNameContainingIgnoreCase(name);
    }

    public ProfileEntity saveProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }
}