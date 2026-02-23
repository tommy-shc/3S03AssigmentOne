import org.junit.jupiter.api.Test;           
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
    }

    @Test
    public void testStandardFunctionality() {
        int dividend = 10;
        int divisor = 2;

        assertEquals(5, calculator.divide(dividend, divisor));
    }

    @Test
    public void testDivideOverflow() {
        double massiveNumber = Double.MAX_VALUE;
        double smallFraction = 0.5;

        //massive number divided by 0.5 == massive number x2
        double result = this.calculator.divide(massiveNumber, smallFraction);

        //Make sure it becomes positive inf, doesnt overflow to small number
        assertEquals(Double.POSITIVE_INFINITY, result,0);
    }

    @Test
    public void testDivideByZeroIsNaN() {
        int dividend = 0;
        int divisor = 100;

        assertTrue(Double.isNaN(calculator.divide(divisor,dividend)),"Result should be NaN");
    }

    @Test
    public void testNaNNumeratorInput() {
        double result = calculator.divide(Double.NaN, 5.0);
        assertTrue(Double.isNaN(result)); 
    }

    @Test
    public void testDivideByInfinity() {
        double result = calculator.divide(100.0, Double.POSITIVE_INFINITY);
        
        assertEquals(0.0, result, 0.0, "number divided by inf should be 0.0");
    }

    @Test
    public void testDividePositiveInfinityByNumber() {
        double result = calculator.divide(Double.POSITIVE_INFINITY, 2.0);
        
        assertEquals(Double.POSITIVE_INFINITY, result, "inf divided by positive num should stll be inf");
    }

    @Test
    public void testResultIsPositiveInfinity() {
        double result = calculator.divide(Double.MAX_VALUE, 0.1);
        
        assertEquals(Double.POSITIVE_INFINITY, result, "Result should overflow to pos inf");
    }

    @Test
    public void testResultIsNegativeInfinity() {
        double result = calculator.divide(-Double.MAX_VALUE, 0.1);
        
        assertEquals(Double.NEGATIVE_INFINITY, result, "Result should overflow to neg inf");
    }

    @Test
    public void testDivideUnderflow() {
        double massiveNumber = Double.MAX_VALUE;
        double smallnum = Double.MIN_VALUE;


        double result = this.calculator.divide(smallnum, massiveNumber);

        //make sure it becomes negative inf, doesnt underflow to large number
        assertEquals(0, result,0,"Should be 0");
    }
}
