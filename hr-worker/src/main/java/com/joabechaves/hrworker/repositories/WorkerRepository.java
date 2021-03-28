package com.joabechaves.hrworker.repositories;

import com.joabechaves.hrworker.entites.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
