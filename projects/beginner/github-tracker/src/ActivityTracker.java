import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ActivityTracker {

    public void fetchData(String username) {
        String GITHUB_URL = "https://api.github.com/users" + username + "/events";
        HttpClient httpClient = HttpClient.newHttpClient();

        try {

            // sending and storing request in a response object
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(GITHUB_URL)).header("Accept", "application/vnd.github+json").GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // action statements
            if (response.statusCode() == 404) {
                System.out.println("User not found!");
                return;
            } else if (response.statusCode() == 200) {
                // use gson repo to deal with json.
            } else {
                System.out.println("Error " + response.statusCode() + "!");
            }


        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
