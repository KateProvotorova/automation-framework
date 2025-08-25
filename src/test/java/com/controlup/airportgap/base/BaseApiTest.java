package com.controlup.airportgap.base;

import com.controlup.airportgap.utils.ApiConfigReader;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass(alwaysRun = true)
    public void setup(){
        RestAssured.baseURI = ApiConfigReader.get("base.url");

        RestAssured.filters(
                new RequestLoggingFilter(LogDetail.ALL),
                new ResponseLoggingFilter(LogDetail.ALL)
        );

        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig.logConfig().enablePrettyPrinting(true));
    }
}
