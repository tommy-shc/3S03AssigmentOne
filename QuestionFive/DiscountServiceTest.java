import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {
    private final DiscountService service = new DiscountService();

    @ParameterizedTest
    @CsvSource({
        "100.0, STUDENT10, 90.0",
        "100.0, BLACKFRIDAY, 70.0",
        "100.0, '', 100.0",
        "100.0, UNKNOWN, 100.0"
    })
    void applyDiscount_ShouldCalculateCorrectTotals(double subtotal, String code, double expected) {
        assertEquals(expected, service.applyDiscount(subtotal, code), 0.001);
    }

    @Test
    void applyDiscount_NullCode_ReturnsSubtotal() {
        assertEquals(100.0, service.applyDiscount(100.0, null));
    }

    @Test
    void applyDiscount_InvalidCode_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.applyDiscount(100.0, "INVALID"));
    }
}