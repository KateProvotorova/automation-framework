package com.controlup.airportgap.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DistanceResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private Attributes attributes;

        public Attributes getAttributes() {
            return attributes;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Attributes {
        private double kilometers;

        public double getKilometers() {
            return kilometers;
        }
    }
}
