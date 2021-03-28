package com.joabechaves.hrpayroll2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long id;
    public String name;
    public Double dailyIncome;

}
