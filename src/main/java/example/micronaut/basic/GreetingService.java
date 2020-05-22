package example.micronaut.basic;

import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class GreetingService {

    public Single<Greeting> sayHi(String name) {
        return Single.just(new Greeting("Hello " + name));
    }
}
