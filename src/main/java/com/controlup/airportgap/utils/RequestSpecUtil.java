package com.controlup.airportgap.utils;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.filter.log.LogDetail.ALL;

public class RequestSpecUtil {

    public static RequestSpecification getSpecWithAuth(){
        return new RequestSpecBuilder()
                .setBaseUri(ApiConfigReader.get("base.url"))
                .addHeader("Authorization", "Bearer " + ApiConfigReader.get("token"))
                .setContentType(ContentType.JSON)
                .build();
    }
}
