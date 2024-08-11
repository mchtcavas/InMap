package com.mchtcavas.InMap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbyDto {
    private String name;
    private String icon;
    private int rating;
    private int userRatingsTotal;
    private List<Photo> photos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUserRatingsTotal() {
        return userRatingsTotal;
    }

    public void setUserRatingsTotal(int userRatingsTotal) {
        this.userRatingsTotal = userRatingsTotal;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "NearbyDto{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", rating=" + rating +
                ", userRatingsTotal=" + userRatingsTotal +
                ", photos=" + photos +
                '}';
    }
}
