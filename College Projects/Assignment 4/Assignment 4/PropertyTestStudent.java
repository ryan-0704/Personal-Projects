
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents GFA test cases for a Property object.
 *
 * @author Ryan Jones
 * @version 11/1/2024
 */
class PropertyTestStudent {
	Property propertyOne;
	Property property;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson");

	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	public void testConstructor() {
		assertEquals("Sunsational", property.getPropertyName());
		assertEquals("Beckman", property.getCity());
		assertEquals(2613.0, property.getRentAmount());
		assertEquals("BillyBob Wilson", property.getOwner());
	}

	@Test
	public void testConstructorWithPlot() {
		Property propertyWithPlot = new Property("Mystic Cove", "Lakewood", 5327.0, "Joey BagODonuts", 1, 1, 10, 10);
		assertEquals("Mystic Cove", propertyWithPlot.getPropertyName());
		assertEquals("Lakewood", propertyWithPlot.getCity());
		assertEquals(5327.0, propertyWithPlot.getRentAmount());
		assertEquals("Joey BagODonuts", propertyWithPlot.getOwner());

		assertEquals(1, propertyWithPlot.getPlot().getX());
		assertEquals(1, propertyWithPlot.getPlot().getY());
		assertEquals(10, propertyWithPlot.getPlot().getWidth());
		assertEquals(10, propertyWithPlot.getPlot().getDepth());
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0", propertyOne.toString());
	}

}
