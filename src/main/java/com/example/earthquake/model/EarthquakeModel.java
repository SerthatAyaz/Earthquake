package com.example.earthquake.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class EarthquakeModel {
    private String type;
    private ArrayList<Features> features;
    private ArrayList<Attribute> attributes;
}
