package org.project;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TmdbApp {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: TmdbApp --type <type>");
        }

        if (args[0].equals("--type")) {
            switch (args[1]) {

                case "playing" -> {
                    try {
                        JsonArray jsonResponse = fetchResponse("/now_playing");

                        for (JsonElement element : jsonResponse) {
                            JsonArray resultsArray = element.getAsJsonObject().get("results").getAsJsonArray();

                            for (JsonElement result : resultsArray) {
                                JsonObject resultObject = result.getAsJsonObject();
                                String name = resultObject.get("title").getAsString();
                                String releaseDate = resultObject.get("release_date").getAsString();
                                int popularity = resultObject.get("popularity").getAsInt();
                                int voteCount = resultObject.get("vote_count").getAsInt();
                                int voteAverage = resultObject.get("vote_average").getAsInt();

                                System.out.println("Name: "+ name + "\nRelease Date: " + releaseDate + "\nPopularity: " + popularity + "\nVote Count: " + voteCount + "\nVote Average: " + voteAverage + "\n\n");
                            }
                        }

                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }

                case "popular" -> {
                    try {
                        JsonArray jsonResponse = fetchResponse("/popular");

                        for (JsonElement element : jsonResponse) {
                            JsonArray resultsArray = element.getAsJsonObject().get("results").getAsJsonArray();

                            for (JsonElement result : resultsArray) {
                                JsonObject resultObject = result.getAsJsonObject();
                                String name = resultObject.get("title").getAsString();
                                int popularity = resultObject.get("popularity").getAsInt();
                                String releaseDate = resultObject.get("release_date").getAsString();

                                System.out.println("Name: "+ name + "\nPopularity: " + popularity + "\nRelease Date: " + releaseDate + "\n\n");
                            }
                        }

                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }

                case "top" -> {
                    try {
                        JsonArray jsonResponse = fetchResponse("/top_rated");

                        for (JsonElement element : jsonResponse) {
                            JsonArray resultsArray = element.getAsJsonObject().get("results").getAsJsonArray();

                            for (JsonElement result : resultsArray) {
                                JsonObject resultObject = result.getAsJsonObject();
                                int voteCount = resultObject.get("vote_count").getAsInt();
                                int voteAverage = resultObject.get("vote_average").getAsInt();

                                if (voteCount > voteAverage) {
                                    String releaseDate = resultObject.get("release_date").getAsString();
                                    String name = resultObject.get("title").getAsString();

                                    System.out.println("Name: "+ name + "\nRelease Date: " + releaseDate + "\nVote Count: " + voteCount + "\nVote Average: " + voteAverage + "\n\n");
                                }
                            }
                        }

                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }

                case "upcoming" -> {
                    try {
                        JsonArray jsonResponse = fetchResponse("/upcoming");

                        for (JsonElement element : jsonResponse) {
                            JsonArray resultsArray = element.getAsJsonObject().get("results").getAsJsonArray();

                            for (JsonElement result : resultsArray) {
                                JsonObject resultObject = result.getAsJsonObject();
                                String releaseDate = resultObject.get("release_date").getAsString();
                                LocalDate releaseLocalDate = LocalDate.parse(releaseDate, DateTimeFormatter.ISO_DATE);

                                if (releaseLocalDate.isAfter(LocalDate.now())) {
                                    String name = resultObject.get("title").getAsString();
                                    int popularity = resultObject.get("popularity").getAsInt();

                                    System.out.println("Name: "+ name + "\nRelease Date: " + releaseDate + "\nPopularity: " + popularity + "\nVote Count: " + "\n\n");
                                }
                            }
                        }

                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }

                default -> {}

            }
        } else {
            System.out.println("Usage: TmdbApp --type <type>");
        }
    }

    private static JsonArray fetchResponse(String endpoint) throws URISyntaxException {
        final String TMDB_API_URL = "https://api.themoviedb.org/3/movie" + endpoint;
        final String API_READ_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmN2Q4ZjQ4NjY1ZWQxNGVjNDdhYzczNWU0NjkwNzgzOSIsIm5iZiI6MTc0Mjg1NTk4NS43NTUsInN1YiI6IjY3ZTFkZjMxNGM1Mjc0NjY2NWRjNjQ2NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ch5kfd1m9V1EQu6qRlNhpEjWzgj-lBS63BDn5bqUtB0";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(new URI(TMDB_API_URL))
                .GET()
                .header("Authorization", "Bearer " + API_READ_TOKEN)
                .header("Accept", "application/json").build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new RuntimeException("There is a problem with the request");
            } else if (response.statusCode() == 200) {
                return JsonParser.parseString("[" + response.body() + "]").getAsJsonArray();
            } else {
                throw new RuntimeException("Something went wrong");
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}