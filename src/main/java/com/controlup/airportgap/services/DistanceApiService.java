package com.controlup.airportgap.services;

import com.controlup.airportgap.endpoints.AirportsEndpoints;
import com.controlup.airportgap.models.requests.DistanceRequest;
import com.controlup.airportgap.models.responses.DistanceResponse;
import com.controlup.airportgap.utils.RequestSpecUtil;

import static io.restassured.RestAssured.*;

public class DistanceApiService {

    public static DistanceResponse calculateDistance(DistanceRequest request) {
        return given()
                .spec(RequestSpecUtil.getSpecWithAuth())
                .body(request)
                .when()
                .post(AirportsEndpoints.getDistance())
                .then()
                .statusCode(200)
                .extract()
                .as(DistanceResponse.class);
    }
}
