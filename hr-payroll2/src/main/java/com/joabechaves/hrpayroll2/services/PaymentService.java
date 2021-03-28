package com.joabechaves.hrpayroll2.services;

import com.joabechaves.hrpayroll2.entities.Payment;
import com.joabechaves.hrpayroll2.entities.Worker;
import com.joabechaves.hrpayroll2.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;


    public Payment getPayment(Long workerId, Integer days){

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.dailyIncome, days);
    }
}
