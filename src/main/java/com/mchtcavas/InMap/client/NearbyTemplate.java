package com.mchtcavas.InMap.client;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface NearbyTemplate {
    String getNearby(Long longitude, Long latitude, Long radius) throws IOException, InterruptedException;
}
