package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Status;

@Controller("/status")
public class StatusController {

    @Status(HttpStatus.BAD_REQUEST)
    @Get("/annotation")
    public void badRequest() {
    }

    @Get("/http-status")
    public HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Get("/http-response-body")
    public HttpResponse<ErrorMessage> httpResponseWithBody() {
        return HttpResponse.badRequest(new ErrorMessage("Error message", 400));
    }

    @Get("/mutable-http-response-body")
    public MutableHttpResponse<Object> mutableHttpResponseWithBody() {
        return HttpResponse.badRequest().body(new ErrorMessage("Error message", 400));
    }
}
