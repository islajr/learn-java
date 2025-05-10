package com.projects.weatherapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public ResponseEntity<String> getWeather() {
        return ResponseEntity.ok("Works!");
    }
}
