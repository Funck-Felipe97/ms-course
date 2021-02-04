package com.funck.hrpayroll.clients;

import com.funck.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hr-worker", url = "${hr-worker.host}", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    Worker findById(@PathVariable final Long id);

}
