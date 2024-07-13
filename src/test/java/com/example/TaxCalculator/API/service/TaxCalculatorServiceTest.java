package com.example.TaxCalculator.API.service;

import com.example.TaxCalculator.API.strategy.DefaultTaxStrategy;
import com.example.TaxCalculator.API.strategy.TaxStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TaxCalculatorServiceTest {

    @Mock
    TaxStrategyFactory factory;

    @Mock
    DefaultTaxStrategy strategy;

    @InjectMocks
    private TaxCalculatorService taxCalculatorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculateTax_WhenIncomePassed_ReturnsTax() {
        // Arrange
        double income = 2500000;
        double expectedTax = 583250;

        when(factory.getStrategy("Default")).thenReturn(strategy);
        when(strategy.calculateTax(income)).thenReturn(expectedTax);

        // Act
        double result = taxCalculatorService.calculateTax(income);

        // Assert
        assertEquals(expectedTax, result);
    }
}
