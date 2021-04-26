package example.micronaut.basic;

import io.micronaut.core.version.VersionUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/")
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Get("/hello/{name}")
    public Single<Greeting> sayHi(String name) {
        return greetingService.sayHi(name);
    }

    @Get("/version")
    public String version() {
        return VersionUtils.MICRONAUT_VERSION;
    }

    @Get("/color/{color}")
    public Color color(Color color) {
        return color;
    }
}
