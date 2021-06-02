package example.micronaut.basic;

import io.reactivex.Single;
import jakarta.inject.Singleton;

@Singleton
public class GreetingService {

    public Single<Greeting> sayHi(String name) {
        return Single.just(new Greeting("Hello " + name));
    }
}
