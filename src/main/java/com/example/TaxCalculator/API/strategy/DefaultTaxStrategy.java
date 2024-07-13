package com.example.TaxCalculator.API.strategy;

import org.springframework.stereotype.Component;

@Component
public class DefaultTaxStrategy implements TaxStrategy{

    @Override
    public double calculateTax(double income) {
        double tax = 0.0;

        if (income > 1200000) {
            tax += (income - 1200000) * 0.35;
            income = 1200000;
        }

        if (income > 625000) {
            tax += (income - 625000) * 0.18;
            income = 625000;
        }

        if (income > 350000) {
            tax += (income - 350000) * 0.09;
            income = 350000;
        }

        return tax;
    }
}