package com.mchtcavas.InMap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
    private List<String> htmlAttributions;

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "htmlAttributions=" + htmlAttributions +
                '}';
    }
}
