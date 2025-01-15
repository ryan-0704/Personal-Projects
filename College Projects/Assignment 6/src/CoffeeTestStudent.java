import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	private Coffee coffee1;
	private Coffee coffee2;

	@BeforeEach
	void setUp() {
		coffee1 = new Coffee("Latte", Size.MEDIUM, true, false);
		coffee2 = new Coffee("Espresso", Size.SMALL, false, true);
	}

	@Test
	void testConstructor() {
		assertEquals("Latte", coffee1.getBevName());
		assertEquals(Size.MEDIUM, coffee1.getSize());
		assertTrue(coffee1.getExtraShot());
		assertFalse(coffee1.getExtraSyrup());
	}

	@Test
	void testGetExtraShot() {
		assertTrue(coffee1.getExtraShot());
		assertFalse(coffee2.getExtraShot());
	}

	@Test
	void testGetExtraSyrup() {
		assertFalse(coffee1.getExtraSyrup());
		assertTrue(coffee2.getExtraSyrup());
	}

	@Test
	public void testCalcPrice() {
        Coffee coffee = new Coffee("Deluxe Coffee", Size.LARGE, true, true);
        
        assertEquals(4.0, coffee.calcPrice(), 0.01);
    }

	@Test
	void testToString() {
		String expectedString1 = "Coffee [extra shot=true, extra syrup=false, Name()=Latte, Size=MEDIUMPrice: 3.0]";
		assertEquals(expectedString1, coffee1.toString());

		String expectedString2 = "Coffee [extra shot=false, extra syrup=true, Name()=Espresso, Size=SMALLPrice: 2.5]";
		assertEquals(expectedString2, coffee2.toString());
	}

	@Test
	void testEquals() {
		Coffee coffee3 = new Coffee("Latte", Size.MEDIUM, true, false);
		Coffee coffee4 = new Coffee("Cappuccino", Size.LARGE, true, true);

		assertTrue(coffee1.equals(coffee3));
		assertFalse(coffee1.equals(coffee4));
	}
}
