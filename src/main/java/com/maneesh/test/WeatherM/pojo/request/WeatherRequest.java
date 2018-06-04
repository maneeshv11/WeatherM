package com.maneesh.test.WeatherM.pojo.request;

public class WeatherRequest {
    double latitude;
    double longitude;

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

    @Override
    public String toString() {
        return "WeatherRequest{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
