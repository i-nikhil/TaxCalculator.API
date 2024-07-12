package com.example.TaxCalculator.API.service;

import com.example.TaxCalculator.API.strategy.TaxStrategy;
import com.example.TaxCalculator.API.strategy.TaxStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculatorService {

    TaxStrategyFactory factory;

    @Autowired
    public TaxCalculatorService(TaxStrategyFactory factory) {
        this.factory = factory;
    }

    public double calculateTax(double income)
    {
        TaxStrategy strategy = factory.getStrategy("Default");
        return strategy.calculateTax(income);
    }
}

