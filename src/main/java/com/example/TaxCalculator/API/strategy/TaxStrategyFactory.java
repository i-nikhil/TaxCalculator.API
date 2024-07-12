package com.example.TaxCalculator.API.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxStrategyFactory {

    DefaultTaxStrategy defaultTaxStrategy;

    @Autowired
    public TaxStrategyFactory(DefaultTaxStrategy defaultTaxStrategy) {
        this.defaultTaxStrategy = defaultTaxStrategy;
    }

    // In the future, this method can be extended to add different strategies.
    public TaxStrategy getStrategy(String name)
    {
        TaxStrategy strategy = null;

        switch(name)
        {
            case "Default": strategy = defaultTaxStrategy;
            break;
            case "RevisedTax2024": strategy = null;
            break;
            case "RevisedTax2025": strategy = null;
            break;
        }
        return strategy;
    }
}