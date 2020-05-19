package example.micronaut;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller("/icndb")
public class IcndbController {

    private final IcndbClient icndbClient;
    private final ObjectMapper mapper;

    public IcndbController(IcndbClient icndbClient,
                           ObjectMapper mapper) {
        this.icndbClient = icndbClient;
        this.mapper = mapper;
    }

    @Get("/http-client")
    public Joke getJoke() {
        return icndbClient
                .getRandomJoke()
                .orElse(null);
    }

    @Get("/http-url-connection")
    public Joke getJoke2() throws IOException {
        URL url = new URL("https://api.icndb.com/jokes/random/?limitTo=[nerdy]");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
        con.setInstanceFollowRedirects(true);

        int status = con.getResponseCode();
        System.out.println(status);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return mapper.readValue(content.toString(), Joke.class);
    }
}
