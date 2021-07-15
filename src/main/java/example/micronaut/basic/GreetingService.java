package example.micronaut.basic;

import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
public class GreetingService {

    public Mono<Greeting> sayHi(String name) {
        return Mono.just(new Greeting("Hello " + name));
    }
}
