package com.userLocation.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userLocation.Entity.UserLocation;

@Repository

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
	List<UserLocation> findByExcludedFalseOrderByDistanceFromOriginAsc(Pageable pageable);
	

}
