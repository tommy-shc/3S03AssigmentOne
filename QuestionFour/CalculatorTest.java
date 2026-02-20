import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    // This method runs before each test method
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testDivideByZeroIsNaN() {
        int dividend = 0;
        int divisor = 100;

        assertTrue(Double.isNaN(calculator.divide(divisor,dividend)), "Result should be NaN");
    }

    @Test
    public void testDivideOverflow() {
        double massiveNumber = Double.MAX_VALUE;
        double smallFraction = 0.5;

        //massive number divided by 0.5 == massive number x2
        double result = calculator.divide(massiveNumber, smallFraction);

        //Make sure it becomes positive inf, doesnt overflow to small number
        assertEquals(Double.POSITIVE_INFINITY, result, "Should overflow to positive infinity");
    }
}
