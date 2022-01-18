package in.purabtech.transaction;

import in.purabtech.transaction.dto.FlightBookingAcknowlegedment;
import in.purabtech.transaction.dto.FlightBookingRequest;
import in.purabtech.transaction.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransactionApplication {


    @Autowired
    private FlightBookingService service;

    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowlegedment bookFlightTicket(@RequestBody FlightBookingRequest request) {
        return service.bookFlightTicket(request);
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

}
