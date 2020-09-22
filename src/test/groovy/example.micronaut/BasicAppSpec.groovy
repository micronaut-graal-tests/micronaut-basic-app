package example.micronaut

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class DemoSpec extends Specification {

    @Inject
    EmbeddedApplication application

    void 'it should fail'() {
        expect:
        false
    }

}