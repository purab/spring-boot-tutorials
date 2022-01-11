package in.purabtech.actuator.controller;

import in.purabtech.actuator.YamlPropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:application.yml",factory = YamlPropertySourceFactory.class)
public class MyTestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test")
    public void testMethod() {
        System.out.println("this is server port:"+serverPort);
    }
}
