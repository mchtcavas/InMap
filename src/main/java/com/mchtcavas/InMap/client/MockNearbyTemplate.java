package com.mchtcavas.InMap.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component("mock")
public class MockNearbyTemplate implements NearbyTemplate {
    @Value("${application.mock.api.base-url}")
    private String baseUrl;
    private final HttpClient httpClient;
    public MockNearbyTemplate(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    @Override
    public String getNearby(Long longitude, Long latitude, Long radius) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
