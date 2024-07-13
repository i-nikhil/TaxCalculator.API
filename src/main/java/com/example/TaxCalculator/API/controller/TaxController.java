package com.example.TaxCalculator.API.controller;

import com.example.TaxCalculator.API.service.TaxCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxController {

    private final TaxCalculatorService service;

    @Autowired
    public TaxController(TaxCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/tax")
    public double calculateTax(@RequestParam double income) {
        if (income <= 0)
            return 0;
        return service.calculateTax(income);
    }
}
