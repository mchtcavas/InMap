package com.mchtcavas.InMap.repository;

import com.mchtcavas.InMap.domain.Nearby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NearbyRepository extends JpaRepository<Nearby, Long> {
    Optional<Nearby> findByLongitudeAndLatitudeAndRadius(Long longitude, Long latitude, Long radius);
}
