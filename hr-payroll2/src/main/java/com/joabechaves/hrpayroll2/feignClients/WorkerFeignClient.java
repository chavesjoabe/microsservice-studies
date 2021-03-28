package com.joabechaves.hrpayroll2.feignClients;


import com.joabechaves.hrpayroll2.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
