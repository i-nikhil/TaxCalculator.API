package com.example.TaxCalculator.API.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultTaxStrategyTest {
    private final TaxStrategy taxStrategy = new DefaultTaxStrategy();


    @Test
    public void calculateTax_IncomeLessThanEqualTo350000_TaxIsZero() {
        // Arrange
        double income = 350000.0;

        // Act
        double tax = taxStrategy.calculateTax(income);

        // Assert
        assertEquals(0.0, tax);
    }

    @Test
    public void calculateTax_IncomeBetween350000And750000_CorrectTaxCalculation() {
        // Arrange
        double income = 650000.0;

        // Act
        double tax = taxStrategy.calculateTax(income);

        // Assert
        assertEquals(29250.0, tax);
    }

    @Test
    public void calculateTax_IncomeAbove1200000_CorrectTaxCalculation() {
        // Arrange
        double income = 1500000.0;

        // Act
        double tax = taxStrategy.calculateTax(income);

        // Assert
        assertEquals(233250.0, tax);
    }

    @Test
    public void calculateTax_NegativeIncome_TaxIsZero() {
        // Arrange
        double income = -100000.0;

        // Act
        double tax = taxStrategy.calculateTax(income);

        // Assert
        assertEquals(0.0, tax);
    }

    @Test
    public void calculateTax_IncomeZero_TaxIsZero() {
        // Arrange
        double income = 0.0;

        // Act
        double tax = taxStrategy.calculateTax(income);

        // Assert
        assertEquals(0.0, tax);
    }

}
