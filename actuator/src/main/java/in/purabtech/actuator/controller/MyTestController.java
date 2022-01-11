package in.purabtech.actuator.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test")
    public void testMethod() {
        System.out.println("this is server port:"+serverPort);
    }
}
