
public class Calculator {
    
    /**
	 * Returns the result of dividing the numerator with the denominator.
	 * Returns a NaN value if the denominator is a 0.
	 * 
	 */
	public double divide(double numerator, double denominator) {
		// Returns NaN if the denominator is 0
		if (denominator == 0) {
			return Double.NaN;
		}
		
		return numerator/denominator;
	}
}
