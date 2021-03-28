package com.joabechaves.hrpayroll.services;

import com.joabechaves.hrpayroll.entites.Payment;
import com.joabechaves.hrpayroll.entites.Worker;
import com.joabechaves.hrpayroll.feignClients.WorkerFeignClient;
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
