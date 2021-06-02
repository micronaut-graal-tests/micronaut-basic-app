package example.micronaut.httpclient;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import jakarta.inject.Singleton;

import java.net.URI;
import java.util.List;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Singleton
public class GithubLowLevelClient {

    private final RxHttpClient httpClient;
    private final URI uri;

    public GithubLowLevelClient(@Client(GithubApiClient.GITHUB_API_URL) RxHttpClient httpClient) {
        this.httpClient = httpClient;
        this.uri = UriBuilder.of(GithubApiClient.GITHUB_RELEASES_URI).build();
    }

    Maybe<List<GithubRelease>> fetchReleases() {
        HttpRequest<?> req = HttpRequest.GET(uri)
                .header(USER_AGENT, "Micronaut HTTP Client")
                .header(ACCEPT, "application/vnd.github.v3+json, application/json");
        Flowable<List<GithubRelease>> flowable = httpClient.retrieve(req, Argument.listOf(GithubRelease.class));
        return flowable.firstElement();
    }
}
