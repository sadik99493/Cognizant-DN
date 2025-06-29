package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    void testAdd() {
        int result = Main.add(2, 3);
        assertEquals(5, result);
    }
}


