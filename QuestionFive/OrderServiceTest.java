import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private final OrderService service = new OrderService();

    @Test
    void processOrder_ValidCard_SetsStatusToPaid() {
        Order order = new Order();
        order.addItem(new OrderItem("Laptop", 1, 1000.0));
        
        // 1000 - 10% (STUDENT10) = 900. 900 + 20% tax (180) = 1080.
        double total = service.processOrder(order, "STUDENT10", "card");
        
        assertEquals(1080.0, total);
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void processOrder_InvalidPaymentMethod_CancelsOrder() {
        Order order = new Order();
        order.addItem(new OrderItem("Phone", 1, 500.0));
        
        double total = service.processOrder(order, null, "crypto");
        
        assertEquals(0.0, total);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }
    
    @Test
    void processOrder_UnknownPaymentMethod_ThrowsException() {
        Order order = new Order();
        assertThrows(UnsupportedOperationException.class, () -> 
            service.processOrder(order, null, "gold_bars")
        );
    }
}