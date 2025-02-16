package com.tasktribe.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "feature")
public class FeatureEndpoint {
    private final Map<String, Feature> featureMap
            = new ConcurrentHashMap<>();
    public FeatureEndpoint() {
        featureMap.put("Job", new Feature(true));
        featureMap.put("Authentication", new Feature(false));
        featureMap.put("User", new Feature(false));
    }
    @ReadOperation
    public Map<String, Feature> getFeatures() {
        return featureMap;
    }
    @ReadOperation
    public Feature getFeature(@Selector String featureName) {
        return featureMap.get(featureName);
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor        
    private static class Feature {
        private boolean isEnabled;
        
    }
}
