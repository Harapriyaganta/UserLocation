package com.userLocation.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userLocation.Entity.UserLocation;
import com.userLocation.Services.UserLocationServices;

@RestController
public class UserLocationController {
    @Autowired
    private UserLocationServices userLocationService;

    @PostMapping("/create_data")
    public ResponseEntity<UserLocation> createData(@RequestBody UserLocation userLocation) {
        UserLocation createdLocation = userLocationService.createUserLocation(userLocation);
        return ResponseEntity.created(URI.create("/create_data/" + createdLocation.getId())).body(createdLocation);
    }

    @PatchMapping("/update_data/{id}")
    public ResponseEntity<UserLocation> updateData(@PathVariable Long id, @RequestBody UserLocation updatedLocation) {
        UserLocation updatedUserLocation = userLocationService.updateUserLocation(id, updatedLocation);
        return ResponseEntity.ok(updatedUserLocation);
    }

    @GetMapping("/get_users/{N}")
    public ResponseEntity<List<UserLocation>> getNearestUsers(@PathVariable int N) {
        List<UserLocation> nearestUsers = userLocationService.getNearestUsers(N);
        return ResponseEntity.ok(nearestUsers);
    }
}


