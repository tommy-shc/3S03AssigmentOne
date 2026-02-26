import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PricingServiceTest {
    private final PricingService service = new PricingService();

    @Test
    void calculateSubtotal_WithMultipleItems_SumsCorrectly() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 2, 10.0)); // 20.0
        order.addItem(new OrderItem("Pen", 1, 5.0));   // 5.0
        
        assertEquals(25.0, service.calculateSubtotal(order));
    }

    @Test
    void calculateTax_AppliesTwentyPercent() {
        assertEquals(20.0, service.calculateTax(100.0));
    }

    @Test
    void calculateTax_ZeroSubtotal_ReturnsZero() {
        assertEquals(0.0, service.calculateTax(0.0));
    }

    @Test
    void calculateTax_NegativeSubtotal_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateTax(-1.0));
    }
}