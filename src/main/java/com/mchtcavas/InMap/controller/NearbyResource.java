package com.mchtcavas.InMap.controller;

import com.mchtcavas.InMap.dto.NearbyDto;
import com.mchtcavas.InMap.service.NearbyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NearbyResource {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final NearbyService nearbyService;
    public NearbyResource(NearbyService nearbyService) {
        this.nearbyService = nearbyService;
    }
    @GetMapping("/nearby")
    public ResponseEntity<List<NearbyDto>> getNearby(@RequestParam("longitude") Long longitude, @RequestParam("latitude") Long latitude, @RequestParam("radius") Long radius) {
        log.debug("Nearby service called with longitude: {}, latitude: {}, radius: {}", longitude, latitude, radius);
        return ResponseEntity.ok(this.nearbyService.getNearby(longitude, latitude, radius));
    }
}
