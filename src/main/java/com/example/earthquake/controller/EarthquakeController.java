package com.example.earthquake.controller;

import com.example.earthquake.model.EarthquakeResponseModel;
import com.example.earthquake.service.EarthquakeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@Validated

public class EarthquakeController {
    private final EarthquakeService service;
    public EarthquakeController(EarthquakeService service) {
        this.service = service;
    }
    @GetMapping(path = "{country}/{countOfDays}")
    public EarthquakeResponseModel getEarthquake(
            @PathVariable String country,
            @PathVariable Integer countOfDays
        )
    {
        return service.getEarthquake(countOfDays,country);
    }
}

