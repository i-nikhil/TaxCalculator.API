package com.example.TaxCalculator.API.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomErrorControllerTest {

    @InjectMocks
    private CustomErrorController errorController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void handleError_WhenErrorOccurs_ReturnsMessage() {
        // Arrange
        String message = "Enter a valid income! Example: http://localhost:8080/tax?income=2500000";

        // Act
        String result = errorController.handleError(null);

        // Assert
        assertNotNull(result);
        assertEquals(message, result);
    }
}
