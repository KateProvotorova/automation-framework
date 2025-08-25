package com.controlup.airportgap.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/api_config.properties");
            properties.load(fileInputStream);
        }  catch (IOException e) {
            throw new RuntimeException("Cannot load api_config.properties", e);
        }
    }
    public static String get(String key){
        return properties.getProperty(key);
    }
}
