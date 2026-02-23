import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;


public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testDivideByZeroIsNaN() {
        int dividend = 0;
        int divisor = 100;

        assertTrue("Result should be NaN",Double.isNaN(calculator.divide(divisor,dividend)));
    }

    @Test
    public void testDivideOverflow() {
        double massiveNumber = Double.MAX_VALUE;
        double smallFraction = 0.5;

        //massive number divided by 0.5 == massive number x2
        double result = calculator.divide(massiveNumber, smallFraction);

        //Make sure it becomes positive inf, doesnt overflow to small number
        assertEquals(Double.POSITIVE_INFINITY, result,0);
    }
}
