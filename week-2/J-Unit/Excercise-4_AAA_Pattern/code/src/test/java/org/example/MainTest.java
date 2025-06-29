package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Main main;

    @BeforeEach
    public void setUp() {
        // Setup: run before each test
        main = new Main();
        System.out.println("Setup complete.");
    }

    @AfterEach
    public void tearDown() {
        // Teardown: run after each test
        System.out.println("Teardown complete.");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = main.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = main.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }
}
