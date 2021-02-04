package com.funck.hrworker.resources;

import com.funck.hrworker.entities.Worker;
import com.funck.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("workers")
public class WorkerResource {

    private final Environment environment;
    private final WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return new ResponseEntity(workerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable final Long id) {
        log.info("Server port: " + environment.getProperty("local.server.port"));

        Worker worker = workerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return ResponseEntity.ok(worker);
    }

}
