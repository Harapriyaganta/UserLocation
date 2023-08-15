package com.userLocation.Services;

import java.util.List;

import com.userLocation.Entity.UserLocation;

public interface UserLocationServices {
	   public UserLocation createUserLocation(UserLocation userLocation);
	    public UserLocation updateUserLocation(Long id, UserLocation updatedUserLocation);
	    public List<UserLocation> getNearestUsers(int N);

}
