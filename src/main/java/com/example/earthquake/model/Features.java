package com.example.earthquake.model;

import lombok.Data;

import java.util.Date;

@Data
@jsonPropertyOrder({"country", "place", "mag", "time"})
public class Features {

    private String place;
    private double mag;
    private Object time;
    public Date getTime;{
        return new Date((long) time);
    }

    public String getCountry() {
        try {
            int ind = this.place.indexOf(',')+1;
            return this.place.substring(ind).trim();
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }



}
