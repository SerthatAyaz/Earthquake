package com.example.earthquake.service;

import com.example.earthquake.config.RestTemplatec;
import com.example.earthquake.model.EarthquakeModel;
import com.example.earthquake.model.EarthquakeResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EarthquakeService implements IEarthquakeService{

    private final RestTemplatec restTemplatec;

    public EarthquakeService(RestTemplatec restTemplatec) {
        this.restTemplatec = restTemplatec;
    }
    @Override
    public EarthquakeResponseModel getEarthquake(Integer countOfDays, String country) {
        try {
            EarthquakeResponseModel responseModel = new EarthquakeResponseModel();
            LocalDate endDate=LocalDate.now();
            LocalDate startDate=LocalDate.now().minusDays(countOfDays);
            String api ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime="+startDate+"&endtime="+endDate;

            ResponseEntity<EarthquakeModel> result = restTemplatec.
                    getForEntity(api, EarthquakeModel.class);
            EarthquakeModel earthquakeModel =result.getBody();


            responseModel.setEarthquakes(earthquakeModel.getFeatures().stream().filter(attribute ->
                    attribute.getFeatures.getCountry().equals(country)).collect(Collectors.toList()));

            if(responseModel.getEarthquakes().isEmpty()) {
                responseModel.setMessage(String.format("No Earthquakes were recorded past %s days.",countOfDays));
            }
            else {
                responseModel.setMessage("Success");
            }

            return responseModel;
        } catch (RestClientException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
