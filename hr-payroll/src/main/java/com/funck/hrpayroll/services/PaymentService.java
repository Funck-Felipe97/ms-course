package com.funck.hrpayroll.services;

import com.funck.hrpayroll.clients.WorkerFeignClient;
import com.funck.hrpayroll.entities.Payment;
import com.funck.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
