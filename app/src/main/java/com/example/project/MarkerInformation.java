package com.example.project;

public class MarkerInformation {
    public String title;
    public double latitude;
    public double longitude;
    public  String level;
    public int report_times;

    public MarkerInformation(){

    }

    public MarkerInformation(String title,double latitude,double longitude,String level,int report_times){
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.level=level;
        this.report_times = report_times;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
