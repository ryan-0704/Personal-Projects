import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class BevShopTestStudent {

    private BevShop bevShop;

    @BeforeEach
    void setUp() {
        bevShop = new BevShop();
    }

    @Test
    void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
        assertTrue(bevShop.isValidTime(23));
        assertFalse(bevShop.isValidTime(7));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(BevShopInterface.MAX_FRUIT, bevShop.getMaxNumOfFruits());
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(BevShopInterface.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT + 1));
        assertFalse(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT));
    }

    @Test
    void testIsEligibleForMore() {
        assertFalse(bevShop.isEligibleForMore());
        // Simulate max alcohol orders
        for (int i = 0; i < BevShopInterface.MAX_ORDER_FOR_ALCOHOL; i++) {
            bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
            bevShop.processAlcoholOrder("Wine", Size.SMALL);
        }
        assertTrue(bevShop.isEligibleForMore());
    }

    @Test
    void testIsValidAge() {
        assertTrue(bevShop.isValidAge(BevShopInterface.MIN_AGE_FOR_ALCOHOL));
        assertFalse(bevShop.isValidAge(BevShopInterface.MIN_AGE_FOR_ALCOHOL - 1));
    }

    @Test
    void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
        assertEquals("John Doe", bevShop.getCurrentOrder().getCust().getName());
    }

    @Test
    void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        assertEquals(1, bevShop.getCurrentOrder().getOrder().size());
    }

    @Test
    void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processAlcoholOrder("Wine", Size.SMALL);
        assertEquals(1, bevShop.getCurrentOrder().getOrder().size());
    }

    @Test
    void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);
        assertEquals(1, bevShop.getCurrentOrder().getOrder().size());
    }

    @Test
    void testFindOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        int orderNo = bevShop.getCurrentOrder().getOrderNumber();
        assertEquals(0, bevShop.findOrder(orderNo));
        assertEquals(-1, bevShop.findOrder(orderNo + 1));
    }

    @Test
    void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        double expectedPrice = bevShop.getCurrentOrder().calcOrderTotal();
        assertEquals(expectedPrice, bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNumber()));
    }

    @Test
    void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        double firstOrderPrice = bevShop.getCurrentOrder().calcOrderTotal();

        bevShop.startNewOrder(12, Day.TUESDAY, "Jane Smith", 30);
        bevShop.processSmoothieOrder("Green Smoothie", Size.LARGE, 2, false);
        double secondOrderPrice = bevShop.getCurrentOrder().calcOrderTotal();

        assertEquals(firstOrderPrice + secondOrderPrice, bevShop.totalMonthlySale());
    }

    @Test
    void testSortOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.startNewOrder(12, Day.TUESDAY, "Jane Smith", 30);
        bevShop.startNewOrder(9, Day.WEDNESDAY, "Alice Brown", 28);

        bevShop.sortOrders();

        assertTrue(bevShop.getOrderAtIndex(0).getOrderNumber() < bevShop.getOrderAtIndex(1).getOrderNumber());
        assertTrue(bevShop.getOrderAtIndex(1).getOrderNumber() < bevShop.getOrderAtIndex(2).getOrderNumber());
    }

    @Test
    void testToString() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        String result = bevShop.toString();
        assertTrue(result.contains("Total monthly sale:"));
        assertTrue(result.contains("John Doe"));
    }
}
