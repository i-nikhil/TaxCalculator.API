package com.example.TaxCalculator.API.controller;

import com.example.TaxCalculator.API.service.TaxCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TaxControllerTest {
    @Mock
    private TaxCalculatorService taxCalculatorService;

    @InjectMocks
    private TaxController taxController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculateTax_WhenValidIncome_ReturnsTax() {
        // Arrange
        double income = 2500000;
        double expectedTax = 583250;

        when(taxCalculatorService.calculateTax(income)).thenReturn(expectedTax);

        // Act
        double calculatedTax = taxController.calculateTax(income);

        // Assert
        assertEquals(expectedTax, calculatedTax);
    }

    @Test
    public void calculateTax_WhenInvalidIncome_ReturnsZero() {
        // Arrange
        double income = 0.0;

        // Act
        double calculatedTax = taxController.calculateTax(income);

        // Assert
        assertEquals(0.0, calculatedTax);
    }
}
