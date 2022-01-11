package in.purabtech.actuator.controller;

import in.purabtech.actuator.YamlPropertySourceFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customActuator")
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:application.yml",factory = YamlPropertySourceFactory.class)
public class CustomActuator {

    /* readoperation maps to http get
        writeoperation map to http post
        deleteoperation map to http delete
     */
    @ReadOperation
    public String currentDBDetails() {
        return "Give current DB status of the application.";
    }
}
