package com.projects.weatherapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {
        @Value("${weather.api.url}") String baseURL;
        @Value("${weather.api.key}") private String key;

    public ResponseEntity<String> getWeather(String location, String start, String end) {

        // input sanitation


        // connection to third-party api
        HttpResponse<String> response = sendRequest(location, start, end);

        // requests and caching

        // response filtering and display
        return ResponseEntity.status(response.statusCode()).body(response.body());


    }

    private HttpResponse<String> sendRequest(String location, String start, String end) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;

        // validation
        if (start.equals("null")){   // if there is no start date
            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI(baseURL + location + "?key=" + key))
                        .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI(baseURL + location + "/" + start + "/" + "end" + "?key=" + key))
                        .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
