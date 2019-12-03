package example.micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ErrorMessage {

    private String message;
    private int code;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
