package dev.vf.ch10;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
