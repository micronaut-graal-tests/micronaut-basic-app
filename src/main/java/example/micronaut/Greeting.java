package example.micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Greeting {

    private String msg;

    public Greeting() {
    }

    public Greeting(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
