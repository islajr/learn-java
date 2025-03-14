package org.example;

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
                System.out.println("Please, input a proper username!");
            }
        }
    }

    private static void fetchData(String username) {
        String GITHUB_URL = "https://api.github.com/users/" + username + "/events";
        HttpClient httpClient = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(GITHUB_URL)).header("Accept", "application/vnd.github+json").GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}