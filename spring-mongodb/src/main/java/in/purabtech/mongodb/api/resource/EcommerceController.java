package in.purabtech.mongodb.api.resource;

import in.purabtech.mongodb.api.model.User;
import in.purabtech.mongodb.api.repository.EcommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class EcommerceController {

    @Autowired
    private EcommerceRepository ecommerceRepository;

    @PostMapping("/placeOrderNow")
    public String placeOrder(@RequestBody User user) {
        ecommerceRepository.save(user);
        return "order placed successfully.";
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserByName(@PathVariable String name){
        return ecommerceRepository.findByName(name);
    }

    @GetMapping("/getUserByAddress/{city}")
    public List<User> getUserByAddress(@PathVariable String city){
        return ecommerceRepository.findByCity(city);
    }

}
