package com.maneesh.test.WeatherM.pojo.dto;

import org.json.simple.JSONObject;

public class WeatherDTO {
    private double latitude;
    private double longitude;
    private long currentEpochTime;
    private String summary;
    private double temperature;
    private double pressure;
    private double windSpeed;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getCurrentEpochTime() {
        return currentEpochTime;
    }

    public void setCurrentEpochTime(long currentEpochTime) {
        this.currentEpochTime = currentEpochTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public static WeatherDTO createWeatherDTO(JSONObject jsonObject){
        JSONObject currently = (JSONObject) jsonObject.get("currently");

        WeatherDTO weatherDTO = new WeatherDTO();

        weatherDTO.setLatitude((double)jsonObject.get("latitude"));
        weatherDTO.setLongitude((double)jsonObject.get("longitude"));

        weatherDTO.setCurrentEpochTime((long) currently.get("time"));
        weatherDTO.setSummary((String) currently.get("summary"));
        weatherDTO.setTemperature((double) currently.get("temperature"));
        weatherDTO.setPressure((double) currently.get("pressure"));
        weatherDTO.setWindSpeed((double) currently.get("windSpeed"));

        return weatherDTO;

    }


    @Override
    public String toString() {
        return "WeatherDTO{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", currentEpochTime=" + currentEpochTime +
                ", summary='" + summary + '\'' +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
