package com.userLocation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.userLocation.Entity.UserLocation;
import com.userLocation.repository.UserLocationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserLocationServicesImpl implements UserLocationServices {
    @Autowired
    
    private UserLocationRepository userLocationRepository;

    public UserLocation createUserLocation(UserLocation userLocation) {
        return userLocationRepository.save(userLocation);
    }

    public UserLocation updateUserLocation(Long id, UserLocation updatedUserLocation) {
        UserLocation existingUserLocation = userLocationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User Location not found"));

        // Update fields of existingUserLocation with updatedUserLocation

        return userLocationRepository.save(existingUserLocation);
    }

    public List<UserLocation> getNearestUsers(int N) {
        Pageable pageable = PageRequest.of(0, N);
        return userLocationRepository.findByExcludedFalseOrderByDistanceFromOriginAsc(pageable);
    }
}