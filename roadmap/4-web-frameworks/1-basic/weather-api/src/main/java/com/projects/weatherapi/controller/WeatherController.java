package com.projects.weatherapi.controller;


import com.projects.weatherapi.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/api/weather")
    public ResponseEntity<String> getWeather(
            @RequestParam String location,
            @RequestParam(required = false, defaultValue = "null")String start,
            @RequestParam(required = false, defaultValue = "null")String end) {

        if (!start.equals("null") && !end.equals("null") || start.equals("null") && end.equals("null") || !start.equals("null") && end.equals("null")){
            if (!start.isBlank() && !end.isBlank()) {
                return weatherService.getWeather(location, start, end);
            }
            return ResponseEntity.badRequest().body("Please provide valid arguments.");
        }

        return ResponseEntity.badRequest().body("Please provide valid arguments.");
    }

}
