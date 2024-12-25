package org.emsi.ordermicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> processOrder(@RequestBody(required = false) String request) {
        System.out.println("Received order request: {}" + request);
        var result = orderService.processOrder();
        System.out.println("Order processed result: {}" + result);
        return ResponseEntity.ok(result);
    }
}
