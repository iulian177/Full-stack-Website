package ro.springTutorial.myspringapi;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
    public String sayHello() {
        return "MyClass says hello!";
    }
}
