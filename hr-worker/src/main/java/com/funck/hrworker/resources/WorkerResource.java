package com.funck.hrworker.resources;

import com.funck.hrworker.entities.Worker;
import com.funck.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("workers")
public class WorkerResource {

    private final WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return new ResponseEntity(workerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findAll(@PathVariable final Long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return ResponseEntity.ok(worker);
    }

}
