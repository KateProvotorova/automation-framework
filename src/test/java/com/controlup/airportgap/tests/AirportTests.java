package com.controlup.airportgap.tests;

import com.controlup.airportgap.base.BaseApiTest;
import com.controlup.airportgap.endpoints.AirportsEndpoints;
import com.controlup.airportgap.models.requests.DistanceRequest;
import com.controlup.airportgap.models.responses.DistanceResponse;
import com.controlup.airportgap.services.DistanceApiService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class AirportTests extends BaseApiTest {

    @Test(groups = "api")
    public void verifyTotalNumberOfAirports() {
        Response response = given()
                .when()
                .get(AirportsEndpoints.getAirports())
                .then()
                .statusCode(200)
                .extract().response();

        int actualNumber = response.path("data.size()");
        Assert.assertEquals(actualNumber, 30, "Expected 30 airports in response");
    }

    @Test(groups = "api")
    public void verifyRequiredAirports(){
        Response response = given()
                .when()
                .get(AirportsEndpoints.getAirports())
                .then()
                .statusCode(200)
                .extract().response();

        List<String> airportNames = response.path("data.attributes.name");

        Assert.assertTrue(airportNames.contains("Akureyri Airport"), "Missing: Akureyri Airport");
        Assert.assertTrue(airportNames.contains("St. Anthony Airport"), "Missing: St. Anthony Airport");
        Assert.assertTrue(airportNames.contains("CFB Bagotville"), "Missing: CFB Bagotville");
    }

    @Test(groups = "api")
    public void verifyDistanceBetweenAirports(){
        DistanceRequest distanceRequest = new DistanceRequest("KIX", "NRT");
        DistanceResponse distanceResponse = DistanceApiService.calculateDistance(distanceRequest);
        double distance = distanceResponse.getData().getAttributes().getKilometers();
        Assert.assertTrue(distance > 400, "Distance is not greater than 400 km, actual: " + distance);
    }
}
