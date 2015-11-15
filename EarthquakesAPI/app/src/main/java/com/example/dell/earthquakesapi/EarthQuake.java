package com.example.dell.earthquakesapi;

/**
 * Created by possiblelabs on 10/17/15.
 */
public class EarthQuake {

    private double magnitude;
    private double lat;
    private double lng;

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    private double depth;

    public EarthQuake(double magnitude, double lat, double lng) {
        this.magnitude = magnitude;
        this.lat = lat;
        this.lng = lng;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return  "magnitude=" + magnitude +
                "\nlat=" + lat +
                "\nlng=" + lng +
                "\ndepth=" + depth +
                '}';
    }
}
