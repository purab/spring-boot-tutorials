package in.purabtech.contextpath;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping
    public String index() {
        return "Welcome to change context path in spring boot application demo...";
    }
}
