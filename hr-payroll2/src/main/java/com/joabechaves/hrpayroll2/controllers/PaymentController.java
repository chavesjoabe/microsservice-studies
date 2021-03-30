package com.joabechaves.hrpayroll2.controllers;

import com.joabechaves.hrpayroll2.entities.Payment;
import com.joabechaves.hrpayroll2.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> getPaymentAlternative( Long workerId,  Integer days){
        Payment payment = new Payment("José das Couves", 500.0, 12);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    }
