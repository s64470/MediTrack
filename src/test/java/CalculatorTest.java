import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("2 + 3 sollte 5 ergeben")
    public void testAddPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName(("Negative Zahlen korrekt addieren"))
    public void testAddNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    @DisplayName("Addition mit Null")
    public void testAddWithZero() {
        assertEquals(7, calculator.add(7, 0));
        assertEquals(7, calculator.add(0, 7));
    }
}