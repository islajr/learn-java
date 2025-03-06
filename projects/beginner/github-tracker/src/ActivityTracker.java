import java.net.http.HttpClient;
import java.util.Optional;

public class ActivityTracker {

    public Optional<String> track(String username) {
        String GITHUB_URL = "https://api.github.com/users" + username + "/events";

        HttpClient httpClient = HttpClient.newHttpClient();
    }

}
