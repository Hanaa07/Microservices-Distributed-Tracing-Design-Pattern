package org.emsi.paymentmicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/payment/process")
    public ResponseEntity<Boolean> payment(@RequestBody(required = false) String request) {
        System.out.println("Received payment request: {}" + request);
        boolean result = true;
        System.out.println("Payment result: {}" + result);
        return ResponseEntity.ok(result);
    }
}
