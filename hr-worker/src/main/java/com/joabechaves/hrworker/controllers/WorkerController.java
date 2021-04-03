package com.joabechaves.hrworker.controllers;

import com.joabechaves.hrworker.entites.Worker;
import com.joabechaves.hrworker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    //@Value("${test.config}")
    //private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerService service;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfig(){
        //logger.info("Config = "+testConfig);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */


        logger.info("port = "+ env.getProperty("local.server.port"));

        return ResponseEntity.status(HttpStatus.OK).body(this.service.findById(id));
    }
}
