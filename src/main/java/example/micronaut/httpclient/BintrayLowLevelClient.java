package example.micronaut.httpclient;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

import javax.inject.Singleton;
import java.net.URI;
import java.util.List;

@Singleton
public class BintrayLowLevelClient {

    private final RxHttpClient httpClient;
    private final URI uri;

    public BintrayLowLevelClient(@Client(BintrayClient.BINTRAY_API_URL) RxHttpClient httpClient) {
        this.httpClient = httpClient;
        this.uri = UriBuilder.of(BintrayClient.BINTRAY_URI_PACKAGES).build();
    }

    Maybe<List<BintrayPackage>> fetchPackages() {
        HttpRequest<?> req = HttpRequest.GET(uri);
        Flowable flowable = httpClient.retrieve(req, Argument.listOf(BintrayPackage.class));
        return (Maybe<List<BintrayPackage>>) flowable.firstElement();
    }

}
