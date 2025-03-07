import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ActivityTracker {

    public Optional<String> fetchData(String username) {
        String GITHUB_URL = "https://api.github.com/users" + username + "/events";
        HttpClient httpClient = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(GITHUB_URL)).header("Accept", "application/vnd.github+json").GET().build();
            HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
