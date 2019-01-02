package pl.dopierala;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RequestController {
    private final String greetMessage = "Hello REST service.";
    private AtomicLong counter = new AtomicLong();
    private Gson gson = new Gson();

    @RequestMapping(path = "/greeting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting(@RequestParam(defaultValue = "Anonymous") String name) {
        Greeting greet = new Greeting(counter.incrementAndGet(), greetMessage + "It's very nice to meet You "+name);
        //String stringJSON = gson.toJson(greet);
        //return stringJSON;
        return greet;
    }
}
