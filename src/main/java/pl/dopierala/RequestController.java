package pl.dopierala;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RequestController {
    private final String greetMessage = "Hello REST service.";
    private AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam String name) {
        return new Greeting(counter.incrementAndGet(), greetMessage + "It's very nice to meet You "+name);
    }
}
