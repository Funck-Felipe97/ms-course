package com.funck.hrpayroll.services;

import com.funck.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WorkerIntegration {

    private final String hrWorkerPath;
    private final RestTemplate restTemplate;

    public WorkerIntegration(@Value("${hr-worker.host}") String hrWorkerHost, RestTemplate restTemplate) {
        this.hrWorkerPath = hrWorkerHost + "/workers/{id}";
        this.restTemplate = restTemplate;
    }

    public Worker getWorkerById(Long workerId) {
        Map<String, String> uriVariable = Map.of("id", workerId.toString());

        return restTemplate.getForObject(hrWorkerPath, Worker.class, uriVariable);
    }

}
