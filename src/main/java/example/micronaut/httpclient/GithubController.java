package example.micronaut.httpclient;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

import java.util.List;

@Controller("/github")
public class GithubController {

    private final GithubLowLevelClient githubLowLevelClient;
    private final GithubApiClient githubApiClient;

    public GithubController(GithubLowLevelClient githubLowLevelClient,
                            GithubApiClient githubApiClient) {
        this.githubLowLevelClient = githubLowLevelClient;
        this.githubApiClient = githubApiClient;
    }

    @Get("/releases-lowlevel")
    Maybe<List<GithubRelease>> releasesWithLowLevelClient() {
        return githubLowLevelClient.fetchReleases();
    }

    @Get(uri = "/releases", produces = MediaType.APPLICATION_JSON_STREAM)
    Flowable<GithubRelease> fetchReleases() {
        return githubApiClient.fetchReleases();
    }
}
