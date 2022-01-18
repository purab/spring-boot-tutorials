package in.purabtech.transaction.service;

import in.purabtech.transaction.dto.FlightBookingAcknowlegedment;
import in.purabtech.transaction.dto.FlightBookingRequest;
import in.purabtech.transaction.entity.PassengerInfo;
import in.purabtech.transaction.entity.PaymentInfo;
import in.purabtech.transaction.reposiory.PassengerInfoRepository;
import in.purabtech.transaction.reposiory.PaymentInfoRepository;
import in.purabtech.transaction.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional //(readOnly = false,isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public FlightBookingAcknowlegedment bookFlightTicket(FlightBookingRequest request) {
        FlightBookingAcknowlegedment acknowlegedment=null;

        PassengerInfo passengerInfo= request.getPassengerInfo();
        passengerInfo =passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo= request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfo = paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowlegedment("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}
