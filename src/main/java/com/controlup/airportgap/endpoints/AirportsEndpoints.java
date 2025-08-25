package com.controlup.airportgap.endpoints;

import com.controlup.airportgap.utils.ApiConfigReader;

public class AirportsEndpoints {

    private static final String BASE_URL = ApiConfigReader.get("base.url");

    private AirportsEndpoints(){
    }

    public static String getAirports(){
        return BASE_URL + "/airports";
    }

    public static String getDistance(){
        return BASE_URL + "/airports/distance";
    }

}
