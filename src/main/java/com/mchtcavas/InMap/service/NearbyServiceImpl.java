package com.mchtcavas.InMap.service;

import com.mchtcavas.InMap.client.NearbyTemplate;
import com.mchtcavas.InMap.config.ApplicationProperties;
import com.mchtcavas.InMap.domain.Nearby;
import com.mchtcavas.InMap.dto.NearbyDto;
import com.mchtcavas.InMap.exception.BusinessException;
import com.mchtcavas.InMap.exception.BusinessExceptionKey;
import com.mchtcavas.InMap.repository.NearbyRepository;
import com.mchtcavas.InMap.util.NearbyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NearbyServiceImpl implements NearbyService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final NearbyRepository nearbyRepository;
    private final NearbyTemplate nearbyTemplate;

    public NearbyServiceImpl(NearbyRepository nearbyRepository, ApplicationContext context, ApplicationProperties properties) {
        this.nearbyRepository = nearbyRepository;
        String beanName = properties.getNearbyTemplate().getKey();
        this.nearbyTemplate = context.getBean(beanName, NearbyTemplate.class);
    }

    @Override
    public List<NearbyDto> getNearby(Long longitude, Long latitude, Long radius) {
        String response = "";
        List<NearbyDto> nearbyDtoList;

        Nearby nearby = this.getNearbyFromDatabase(longitude, latitude, radius);

        if (nearby != null) {
            nearbyDtoList = this.prepareNearbyDtoList(nearby.getResponse());
            return nearbyDtoList;
        }

        response = this.callNearbyTemplate(longitude, latitude, radius);
        nearbyDtoList = this.prepareNearbyDtoList(response);

        this.saveNearby(longitude, latitude, radius, response);

        return nearbyDtoList;
    }

    private Nearby getNearbyFromDatabase(Long longitude, Long latitude, Long radius) {
        log.debug("Searching for nearby with longitude: {}, latitude: {}, and radius: {}", longitude, latitude, radius);

        Optional<Nearby> nearby = this.nearbyRepository.findByLongitudeAndLatitudeAndRadius(longitude, latitude, radius);

        if (nearby.isPresent()) {
            log.debug("Found nearby: {}", nearby.get());
            return nearby.get();
        } else {
            log.debug("No nearby found for longitude: {}, latitude: {}, and radius: {}", longitude, latitude, radius);
        }

        return null;
    }

    private List<NearbyDto> prepareNearbyDtoList(String response) {
        log.debug("Preparing NearbyDto list from response: {}", response);

        List<NearbyDto> nearbyDtoList;
        try {
            nearbyDtoList = NearbyMapper.toNearby(response);
            log.debug("Successfully mapped response to NearbyDto list: {}", nearbyDtoList);
        } catch (Exception exception) {
            log.error("Failed to map response to NearbyDto list. Response: {}, Error: {}", response, exception.getMessage(), exception);
            throw new BusinessException(BusinessExceptionKey.MAPPING_ERROR, exception);
        }

        return nearbyDtoList;
    }

    private String callNearbyTemplate(Long longitude, Long latitude, Long radius) {
        log.debug("Calling nearby template with longitude: {}, latitude: {}, and radius: {}", longitude, latitude, radius);
        String response = "";
        try {
            response = this.nearbyTemplate.getNearby(longitude, latitude, radius);
            log.debug("Received response from nearby template: {}", response);
        } catch (Exception exception) {
            log.error("Failed to call nearby template. Longitude: {}, Latitude: {}, Radius: {}, Error: {}", longitude, latitude, radius, exception.getMessage(), exception);
            throw new BusinessException(BusinessExceptionKey.NEARBY_TEMPLATE_CALL_FAILED, exception);
        }

        return response;
    }
    private void saveNearby(Long longitude, Long latitude, Long radius, String response) {
        log.debug("Saving Nearby with longitude: {}, latitude: {}, radius: {}, and response: {}", longitude, latitude, radius, response);

        Nearby nearby = new Nearby();
        nearby.setLatitude(latitude);
        nearby.setLongitude(longitude);
        nearby.setRadius(radius);
        nearby.setResponse(response);

        this.nearbyRepository.save(nearby);
        log.debug("Successfully saved Nearby with longitude: {}, latitude: {}, radius: {}", longitude, latitude, radius);
    }
}
