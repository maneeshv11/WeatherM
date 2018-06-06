package com.maneesh.test.WeatherM.dao.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maneesh.test.WeatherM.constant.PropertiesConfig;
import com.maneesh.test.WeatherM.pojo.dto.WeatherDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RedisManager {

    private static Logger logger = LoggerFactory.getLogger(RedisManager.class);

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Autowired
    private ObjectMapper objectMapper;

    private String getWeatherDTOKEY(String latitude, String longitude){
        return propertiesConfig.REDIS_WEATHER_DTO_KEY + latitude + ":" + longitude;
    }

    public WeatherDTO getWeatherDTO(String latitude, String longitude){
        String value = RedisPool.getInstance().get(getWeatherDTOKEY(latitude, longitude));
        if (value == null){
            logger.info("Cache mis for latitude : {}, logitude : {}", latitude, longitude);
            return null;
        }
        logger.info("Cache hit for latitude: {}, logitude : {} value : {}" , latitude, longitude, value);
        try {
            return objectMapper.readValue(value, WeatherDTO.class);
        } catch (IOException e) {
            return null;
        }
    }

    public void cacheWeatherDTO(WeatherDTO weatherDTO){
        RedisPool.getInstance().setex(getWeatherDTOKEY(
                String.valueOf(weatherDTO.getLatitude()),
                String.valueOf(weatherDTO.getLongitude())
        ), propertiesConfig.EXPIRY_TIME, weatherDTO.toString());
    }
}
