package in.purabtech.actuator.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customActuator")
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
