package com.projects.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.exceptions.JedisException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class WeatherService {

        @Autowired
        private RedisTemplate<String, String> lettuce;

        @Value("${weather.api.url}") String baseURL;
        @Value("${weather.api.key}") private String key;
        @Value("${spring.data.redis.host}") private String host;
        @Value("${spring.data.redis.port}") private int port;
        @Value("${spring.data.redis.username}") private String username;
        @Value("${spring.data.redis.password}") private String password;

        String elements = "datetime,conditions,description,temp,feelslike,precip,precipprob,preciptype,sunrise,sunset";


        /*UnifiedJedis openConnection() {
            JedisClientConfig config = DefaultJedisClientConfig.builder()
                    .user(username)
                    .password(password)
                    .build();

            UnifiedJedis jedis;

            try {
                jedis = new UnifiedJedis(new HostAndPort(host, port), config);
            } catch (JedisException e) {
                throw new RuntimeException("Connection Failure: Failed to connect to redis");
            }

            return jedis;
        }*/

    public ResponseEntity<String> getWeather(String location, String start, String end) {

        String key = capitalize(location.strip()) + "," + start + "," + end;
//        UnifiedJedis jedis = openConnection();
        String stored = get(key);
        if (!String.valueOf(stored).equals("null")) {   // if present in cache
            return ResponseEntity.ok(stored);
        }   // else

        HttpResponse<String> response = sendRequest(location, start, end);

        switch (response.statusCode()) {
            case 200 -> {
                save(key, response.body());   // cache response for three hours.
                return ResponseEntity.ok(response.body());
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

    }

    private HttpResponse<String> sendRequest(String location, String start, String end) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request;

        // validation
        if (start.equals("null")){   // if there is no start date
            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI(baseURL + location + "?key=" + key + "&include=days&elements=" + elements))
                        .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } else if (!start.equals("null") && end.equals("null")){
            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI(baseURL + location + "/" + start + "?key=" + key + "&include=days&elements=" + elements))
                        .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI(baseURL + location + "/" + start + "/" + end + "?key=" + key + "&include=days&elements=" + elements))
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

    String capitalize(String subject) {
            char index = Character.toUpperCase(subject.charAt(0));
            return index + subject.substring(1);
    }

    private void save(String key, String value) {
            lettuce.opsForValue().set(key, value, Duration.ofSeconds(10800));

    }

    private String get(String key) {
            return lettuce.opsForValue().get(key);
    }
}
