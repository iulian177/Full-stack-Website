package ro.springTutorial.myspringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//adnotation to link this class to main(we don t need to instantiate with new keyword)
@RestController
@RequestMapping(path = "/api/greetings")
public class GreetingsController {
    //this is an endpoint
    @GetMapping(path = "hello")
    public String hello() {
        return "Hello, I'm a Spring Boot application";
    }
    @GetMapping(path = "goodbye")
    public String goodbye() {
        return "Bye!";
    }
}
