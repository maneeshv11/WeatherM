package com.maneesh.weatherm.handler;

import com.maneesh.weatherm.api.DarkSky;
import com.maneesh.weatherm.exception.InternalServerError;
import com.maneesh.weatherm.pojo.dto.WeatherDTO;
import com.maneesh.weatherm.pojo.request.WeatherRequest;
import com.maneesh.weatherm.pojo.response.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherRequestHandler {

    private Logger logger = LoggerFactory.getLogger(WeatherRequestHandler.class);

    @Autowired
    private DarkSky darkSky;

    public WeatherResponse handelWeatherRequest(WeatherRequest weatherRequest) throws InternalServerError {
        try {
            WeatherDTO weatherDTO = darkSky.getCurrentWeather(weatherRequest.getLatitude(), weatherRequest.getLongitude());
            return getWeatherResponseObject(weatherDTO);
        } catch (Exception e) {
            logger.info("Exception for request : {} .\nException : {}", weatherRequest.toString(), e);
            throw new InternalServerError("Something Went Wrong");
        }

    }

    private WeatherResponse getWeatherResponseObject(WeatherDTO weatherDTO){
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setLatitude(weatherDTO.getLatitude());
        weatherResponse.setLongitude(weatherDTO.getLongitude());
        weatherResponse.setCurrentTime(weatherDTO.getCurrentEpochTime());
        weatherResponse.setTemperatre(weatherDTO.getTemperature());
        return weatherResponse;
    }
}
