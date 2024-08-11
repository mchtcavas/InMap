package com.mchtcavas.InMap.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.mchtcavas.InMap.dto.NearbyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NearbyMapper {
    private static final Logger log = LoggerFactory.getLogger(NearbyMapper.class);

    public static List<NearbyDto> toNearby(String response) throws JsonProcessingException {
        log.debug("Starting to parse JSON response to NearbyDto list.");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode subjectsNode = rootNode.get("results");
        List<NearbyDto> nearbyDtoList = objectMapper.convertValue(subjectsNode, new TypeReference<>() {});
        log.debug("Converted JSON to List<NearbyDto> with size: {}", nearbyDtoList.size());

        return nearbyDtoList;
    }
}
