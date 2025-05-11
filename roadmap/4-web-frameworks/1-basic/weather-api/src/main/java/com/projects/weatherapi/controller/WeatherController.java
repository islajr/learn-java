package com.projects.weatherapi.controller;


import com.projects.weatherapi.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/api/weather")
    public ResponseEntity<String> getWeather(
            @RequestParam String location,
            @RequestParam(required = false, defaultValue = "null")LocalDate start,
            @RequestParam(required = false, defaultValue = "null")LocalDate end) {
        return weatherService.getWeather(location, start, end);
    }

}
