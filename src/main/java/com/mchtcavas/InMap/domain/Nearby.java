package com.mchtcavas.InMap.domain;

import jakarta.persistence.*;

@Entity
public class Nearby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long longitude;
    private Long latitude;
    private Long radius;
    @Column(columnDefinition = "LONGTEXT")
    private String response;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Nearby{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", radius=" + radius +
                ", result='" + response + '\'' +
                '}';
    }
}
