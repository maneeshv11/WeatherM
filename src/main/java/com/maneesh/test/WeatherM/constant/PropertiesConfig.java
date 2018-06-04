package com.maneesh.test.WeatherM.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class PropertiesConfig {

    public final String DARK_SKY_API_KEY = System.getenv("API_KEY");

    @Value("${darksky.api}")
    public String darkSkyApiUrl;


}
