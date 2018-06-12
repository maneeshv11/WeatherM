package com.maneesh.weatherm.controller;

import com.maneesh.weatherm.exception.InternalServerError;
import com.maneesh.weatherm.handler.WeatherRequestHandler;
import com.maneesh.weatherm.pojo.request.WeatherRequest;
import com.maneesh.weatherm.pojo.response.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;





@RestController()
public class WeatherForecastController {

    private Logger logger = LoggerFactory.getLogger(WeatherForecastController.class);

    @Autowired
    private WeatherRequestHandler weatherRequestHandler;

    @PostMapping
    @RequestMapping("/weather")
    public @ResponseBody
    WeatherResponse getWeatherForecastResponse(@RequestBody WeatherRequest weatherRequest){
        logger.info("Request recieved : {}", weatherRequest.toString());
        try {
            WeatherResponse weatherResponse = weatherRequestHandler.handelWeatherRequest(weatherRequest);
            logger.info("Sending response : {}", weatherResponse.toString());
            return weatherResponse;
        } catch (InternalServerError internalServerError) {
            return new WeatherResponse();
        }
    }

}
