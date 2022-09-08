package com.example.earthquake.service;

import com.example.earthquake.model.EarthquakeResponseModel;
import com.example.earthquake.model.EarthquakeResponseModel;
import com.example.earthquake.model.Attribute;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface IEarthquakeService {
    EarthquakeResponseModel getEarthquake(Integer countOfDays, String country);
}
