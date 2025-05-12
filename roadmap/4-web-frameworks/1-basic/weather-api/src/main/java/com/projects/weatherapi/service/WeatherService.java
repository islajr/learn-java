package com.projects.weatherapi.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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

        // connection to third-party api
        HttpResponse<String> response = sendRequest(location, start, end);

        switch (response.statusCode()) {
            case 200 -> {
                // cache entire response

                // sort the response and display necessary information.
//                return ResponseEntity.status(response.statusCode()).body(response.body());
                JsonArray content = JsonParser.parseString("[" + response.body() + "]").getAsJsonArray();
                return ResponseEntity.ok(display(content));
            }
            case 400 -> {
                return ResponseEntity.badRequest().body("Please provide valid parameters!");
            }
            case 404 -> {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no such location");
            }
            case 429 -> {
                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("You are rate-limited. Please try again later.");
            }
            case 500 -> {
                return ResponseEntity.internalServerError().body("There was a problem on our end. We're sorry.");
            }
            default -> {
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Unable to establish a connection. Please try again later.");
            }
        }

        // requests and caching

        // response filtering and display


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
        } else if (!start.equals("null") && end.equals("null")){
            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI(baseURL + location + "/" + start + "?key=" + key))
                        .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI(baseURL + location + "/" + start + "/" + end + "?key=" + key))
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

    private String display(JsonArray data) {
        return data.toString();
    }
}
