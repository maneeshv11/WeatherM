package com.maneesh.test.WeatherM.api;

import com.maneesh.test.WeatherM.constant.PropertiesConfig;
import com.maneesh.test.WeatherM.pojo.dto.WeatherDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@Component
public class DarkSky {


    private static Logger logger = LoggerFactory.getLogger(DarkSky.class);


    @Autowired
    private PropertiesConfig propertiesConfig;

    private WeatherDTO getWeatherForecastJsonResponses(String latitude, String longitude) throws Exception {

        HttpURLConnection connection = null;

        String formattedUrl = propertiesConfig.darkSkyApiUrl.concat(propertiesConfig.DARK_SKY_API_KEY).concat("/").concat(latitude).concat(",").concat(longitude);
        URL url = new URL(formattedUrl);
        JSONParser jsonParser = new JSONParser();

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        connection.setUseCaches(false);
        connection.setDoOutput(true);

        if (connection.getResponseCode() == 200) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            return WeatherDTO.createWeatherDTO(jsonObject);
        }
        throw new Exception("Something Went Wrong");


    }


    public WeatherDTO getCurrentWeather(double latitude, double longitude) throws Exception {
        return getWeatherForecastJsonResponses(String.valueOf(latitude), String.valueOf(longitude));
    }
}
