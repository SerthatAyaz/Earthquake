package com.example.earthquake.model;

import lombok.Data;

import java.util.List;

@Data
public class EarthquakeResponseModel {
    private String Message;
    private List<Attribute> earthquakes;
}
