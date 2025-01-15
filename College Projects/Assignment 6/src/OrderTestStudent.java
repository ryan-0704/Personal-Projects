import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTestStudent {
    
    private Order order;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 25);  
        order = new Order(12, Day.SATURDAY, customer); 
    }

    @Test
    public void testGenerateOrder() {
        int orderNumber = order.getOrderNumber();
        assertTrue(orderNumber >= 10000 && orderNumber <= 99999);
    }

    @Test
    public void testIsWeekend() {
        assertTrue(order.isWeekend());
        Order weekdayOrder = new Order(10, Day.MONDAY, customer);
        assertFalse(weekdayOrder.isWeekend());
    }

    @Test
    public void testAddNewBeverage() {
        order.addNewBeverage("Beer", Size.MEDIUM);
        assertEquals(1, order.getTotalItems());
        order.addNewBeverage("Latte", Size.LARGE, true, true);
        assertEquals(2, order.getTotalItems());
        order.addNewBeverage("Strawberry Smoothie", Size.SMALL, 3, true);
        assertEquals(3, order.getTotalItems());
    }

    @Test
    public void testGetBeverage() {
        order.addNewBeverage("Beer", Size.MEDIUM);
        order.addNewBeverage("Latte", Size.LARGE, true, true);
        Beverage beverage = order.getBeverage(0);
        assertNotNull(beverage);
        assertTrue(beverage instanceof Alcohol);
        assertNull(order.getBeverage(5));
    }

    @Test
    public void testCalcOrderTotal() {
        order.addNewBeverage("Beer", Size.MEDIUM);
        order.addNewBeverage("Latte", Size.LARGE, true, true);
        double total = order.calcOrderTotal();
        assertTrue(total > 0);
    }

    @Test
    public void testFindNumOfBeveType() {
        order.addNewBeverage("Beer", Size.MEDIUM);
        order.addNewBeverage("Latte", Size.LARGE, true, true);
        order.addNewBeverage("Strawberry Smoothie", Size.SMALL, 3, true);
        assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    public void testCompareTo() {
        Order anotherOrder = new Order(14, Day.SUNDAY, customer); 
        int comparisonResult = order.compareTo(anotherOrder);
        assertTrue(comparisonResult != 0);
    }

    @Test
    public void testToString() {
        order.addNewBeverage("Beer", Size.MEDIUM);
        order.addNewBeverage("Latte", Size.LARGE, true, true);
        order.addNewBeverage("Strawberry Smoothie", Size.SMALL, 3, true);
        String orderString = order.toString();
        assertTrue(orderString.contains("SATURDAY"));
        assertTrue(orderString.contains("John Doe"));
        assertTrue(orderString.contains("Beer"));
        assertTrue(orderString.contains("Latte"));
        assertTrue(orderString.contains("Strawberry Smoothie"));
    }
}
