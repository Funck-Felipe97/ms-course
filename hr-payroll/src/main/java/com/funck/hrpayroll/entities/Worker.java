package com.funck.hrpayroll.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = "id")
@Data
public class Worker {

    private Long id;
    private String name;
    private Double dailyIncome;

}
