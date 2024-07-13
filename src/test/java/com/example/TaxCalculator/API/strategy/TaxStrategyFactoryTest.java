package com.example.TaxCalculator.API.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class TaxStrategyFactoryTest {

    @Mock
    private DefaultTaxStrategy defaultTaxStrategy;

    @InjectMocks
    private TaxStrategyFactory taxStrategyFactory;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getStrategy_WhenPassedDefault_ReturnsDefaultStrategy() {
        // Arrange
        String strategyName = "Default";

        // Act
        TaxStrategy strategy = taxStrategyFactory.getStrategy(strategyName);

        // Assert
        assertNotNull(strategy);
        assertEquals(defaultTaxStrategy, strategy);
    }

    @Test
    public void testGetNullStrategy() {
        // Arrange
        String strategyName = "RevisedTax2024";

        // Act
        TaxStrategy strategy = taxStrategyFactory.getStrategy(strategyName);

        // Assert
        assertNull(strategy);
    }
}
