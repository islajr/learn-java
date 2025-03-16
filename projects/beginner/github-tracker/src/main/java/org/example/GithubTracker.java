package org.example;

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

public class GithubTracker {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: GithubTracker <username>");
        }
        else {
            try {
                fetchData(args[0]);

            } catch (Exception e) {
//                System.out.println("Please, input a proper username!");
                e.printStackTrace();
            }
        }
    }

    private static void fetchData(String username) {
        String GITHUB_URL = "https://api.github.com/users/" + username + "/events";
        HttpClient httpClient = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(GITHUB_URL)).header("Accept", "application/vnd.github+json").GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                System.out.println("There is no such user!");
            } else if (response.statusCode() == 200) {
                JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();
                displayData(jsonArray);
            } else {
                System.out.println("Something went wrong!");
            }

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayData(JsonArray jsonArray) {
        for (JsonElement element : jsonArray) {
            JsonObject object = element.getAsJsonObject();
            String type = object.get("type").getAsString();

            switch (type) {
                case "PushEvent" -> {
                    int commits = object.get("payload").getAsJsonObject().get("commits").getAsJsonArray().size();
                    System.out.println("Pushed " + commits + " commits to " + object.get("repo").getAsJsonObject().get("name").getAsString() + ".");
                }
                case "IssuesEvent" -> System.out.println(object.get("payload").getAsJsonObject().get("Action").getAsString().toUpperCase().charAt(0) + object.get("payload").getAsJsonObject().get("Action").getAsString() + " an issue in " + object.get("repo").getAsJsonObject().get("name").getAsString());

                case "WatchEvent" -> {
                    if (object.get("payload").getAsJsonObject().get("action").getAsString().equals("started")) {
                        System.out.println("Watching " + object.get("repo").getAsJsonObject().get("name"));
                    }
                }
                case "ForkEvent" -> System.out.println("Forked " + object.get("repo").getAsJsonObject().get("name").getAsString());

                case "CreateEvent" -> System.out.println("Created " + object.get("payload").getAsJsonObject().get("ref_type").getAsString() + " in " + object.get("repo").getAsJsonObject().get("name"));

                default -> throw new IllegalStateException("Unexpected value: " + type);
            }
        }
    }
}