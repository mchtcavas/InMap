package com.mchtcavas.InMap.service;

import com.mchtcavas.InMap.dto.NearbyDto;

import java.util.List;

public interface NearbyService {
    List<NearbyDto> getNearby(Long longitude, Long latitude, Long radius);
}
