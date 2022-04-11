import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class myApp {
    private static final String url ="https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client= HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(url))
                .build();

        HttpResponse<String>response=client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
