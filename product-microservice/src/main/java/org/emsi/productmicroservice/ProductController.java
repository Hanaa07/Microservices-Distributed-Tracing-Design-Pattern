package org.emsi.productmicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    /**
     * Validates the product based on the request.
     *
     * @param request the request body containing product information (can be null)
     * @return ResponseEntity containing the validation result (true)
     */
    @PostMapping("/product/validate")
    public ResponseEntity<Boolean> validateProduct(@RequestBody(required = false) String request) {
        System.out.println("Received product validation request: {}" + request);
        boolean result = true;
        System.out.println("Product validation result: {}" + result);
        return ResponseEntity.ok(result);
    }
}
