package com.example.earthquake.config;


import com.example.earthquake.model.EarthquakeModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

@Configuration
public class RestTemplatec {
        @Bean
        public RestTemplatec restTemplate(){

            return new RestTemplatec();
        }



}

