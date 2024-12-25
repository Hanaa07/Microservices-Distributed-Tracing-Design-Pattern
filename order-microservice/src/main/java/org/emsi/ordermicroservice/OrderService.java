package org.emsi.ordermicroservice;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@Service
public class OrderService {

    private final RestTemplateBuilder restTemplateBuilder;

    public OrderService(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String processOrder() {
        if (validateProduct() && processPayment()) {
            return "Order processed successfully";
        }
        return "Order processing failed";
    }

    Boolean validateProduct() {
        try {
            ResponseEntity<Boolean> productValidationResult = restTemplateBuilder
                    .build()
                    .postForEntity("http://localhost:30302/product/validate", "validating product",
                            Boolean.class);
            System.out.println("Product validation result: {}" + productValidationResult.getBody());
            return productValidationResult.getBody();
        } catch (ResourceAccessException | HttpClientErrorException e) {
            System.out.println("Error communicating with product service: {}" + e.getMessage());
            return false;
        }
    }

    Boolean processPayment() {
        try {
            ResponseEntity<Boolean> paymentProcessResult = restTemplateBuilder
                    .build()
                    .postForEntity("http://localhost:30301/payment/process", "processing payment",
                            Boolean.class);
            System.out.println("Payment processing result: {}" + paymentProcessResult.getBody());
            return paymentProcessResult.getBody();
        } catch (ResourceAccessException | HttpClientErrorException e) {
            System.out.println("Error communicating with payment service: {}" + e.getMessage());
            return false;
        }
    }
}
