package com.joabechaves.hrworker.services;

import com.joabechaves.hrworker.entites.Worker;
import com.joabechaves.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repository;

    public List<Worker> findAll(){
        return this.repository.findAll();
    }

    public Worker findById(Long id){
        return this.repository.findById(id).get();
    }
}
