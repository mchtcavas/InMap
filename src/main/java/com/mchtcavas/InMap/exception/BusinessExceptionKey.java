package com.mchtcavas.InMap.exception;

public enum BusinessExceptionKey {
    MAPPING_ERROR("Error mapping response to NearbyDto list"),
    NEARBY_TEMPLATE_CALL_FAILED("Failed to call nearby template service");
    private final String defaultMessage;

    BusinessExceptionKey(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
