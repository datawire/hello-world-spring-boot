package io.datawire.labs.hellospring;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static long start = System.currentTimeMillis();

    @GetMapping("/")
    public String sayHello() {
        long elapsed = System.currentTimeMillis() - start;
        String uptime = String.format("%d:%d:%d",
                                      TimeUnit.MILLISECONDS.toHours(elapsed),
                                      TimeUnit.MILLISECONDS.toMinutes(elapsed),
                                      TimeUnit.MILLISECONDS.toSeconds(elapsed));
        return String.format("Hello, Spring! (up %s, %s)", uptime, System.getenv("BUILD_PROFILE"));
    }

}
