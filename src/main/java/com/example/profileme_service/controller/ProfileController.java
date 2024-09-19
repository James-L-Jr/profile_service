package com.example.profileme_service.controller;

import com.example.profileme_service.model.ProfileEntity;
import com.example.profileme_service.service.ProfileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Profile", description = "Profile management APIs")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Get a profile by its id")
    @GetMapping("/{id}")
    public ResponseEntity<ProfileEntity> getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Search profiles by name")
    @GetMapping("/search")
    public ResponseEntity<List<ProfileEntity>> searchProfiles(@RequestParam String query) {
        List<ProfileEntity> profiles = profileService.searchProfiles(query);
        return ResponseEntity.ok(profiles);
    }

    @Operation(summary = "Create a new profile")
    @PostMapping
    public ResponseEntity<ProfileEntity> addProfile(@RequestBody ProfileEntity profileEntity) {
        ProfileEntity savedProfile = profileService.saveProfile(profileEntity);
        return ResponseEntity.ok(savedProfile);
    }

    @GetMapping
    public ResponseEntity<List<ProfileEntity>> getAllProfiles() {
        List<ProfileEntity> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }
}