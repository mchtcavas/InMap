package com.mchtcavas.InMap.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private NearbyTemplate nearbyTemplate;
    private Google google;
    private Mock mock;

    public static class NearbyTemplate {
        private String key = "mock";
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static class Google {
        private Api api;
        public Api getApi() {
            return api;
        }

        public void setApi(Api api) {
            this.api = api;
        }

        public static class Api {
            private String baseUrl;
            private String key;
            public String getBaseUrl() {
                return baseUrl;
            }

            public void setBaseUrl(String baseUrl) {
                this.baseUrl = baseUrl;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }

    public static class Mock {
        private Api api;
        public Api getApi() {
            return api;
        }

        public void setApi(Api api) {
            this.api = api;
        }

        public static class Api {
            private String baseUrl;
            public String getBaseUrl() {
                return baseUrl;
            }

            public void setBaseUrl(String baseUrl) {
                this.baseUrl = baseUrl;
            }
        }
    }

    public NearbyTemplate getNearbyTemplate() {
        return nearbyTemplate;
    }

    public void setNearbyTemplate(NearbyTemplate nearbyTemplate) {
        this.nearbyTemplate = nearbyTemplate;
    }

    public Google getGoogle() {
        return google;
    }

    public void setGoogle(Google google) {
        this.google = google;
    }

    public Mock getMock() {
        return mock;
    }

    public void setMock(Mock mock) {
        this.mock = mock;
    }
}
