import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DomainTest {

    @Test
    void orderItem_NegativePrice_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new OrderItem("Bad", 1, -10.0));
    }

    @Test
    void order_AddItemAfterPaid_ThrowsException() {
        Order order = new Order();
        // Manually simulating a processed order state
        OrderService service = new OrderService();
        service.processOrder(order, null, "card");
        
        assertThrows(IllegalStateException.class, () -> order.addItem(new OrderItem("Late", 1, 10.0)));
    }
}