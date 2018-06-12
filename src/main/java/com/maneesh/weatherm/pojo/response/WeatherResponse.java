package com.maneesh.weatherm.pojo.response;

public class WeatherResponse {
    private double latitude;
    private double longitude;
    private double temperatre;
    private long currentTime;

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

    public double getTemperatre() {
        return temperatre;
    }

    public void setTemperatre(double temperatre) {
        this.temperatre = temperatre;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", temperatre=" + temperatre +
                ", currentTime=" + currentTime +
                '}';
    }
}
