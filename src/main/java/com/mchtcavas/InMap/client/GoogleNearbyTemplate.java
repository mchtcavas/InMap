package com.mchtcavas.InMap.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component("google")
public class GoogleNearbyTemplate implements NearbyTemplate {
    @Value("${application.google.api.key}")
    private String apiKey;
    @Value("${application.google.api.base-url}")
    private String baseUrl;
    private final HttpClient httpClient;

    public GoogleNearbyTemplate(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public String getNearby(Long longitude, Long latitude, Long radius) throws IOException, InterruptedException {
        String location = latitude.toString() + "%" + longitude.toString();
        String url = String.format("%s?location=%s&radius=%d&key=%s", baseUrl, location, radius, apiKey);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
