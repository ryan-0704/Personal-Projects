
import static org.junit.Assert.*; 
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a Plot object.
 * 
 * @author Ryan Jones
 * @version 11/2/2024
 * 
 */
public class PlotTestStudent {
	private Plot plot1, plot2, plot3, plot4;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot2 = new Plot(3, 4, 4, 3);
		plot3 = new Plot(2,2,2,2);
		plot4= new Plot(2,2,2,2);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot2 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot2)); // plot2 is entirely inside plot1
	}
	@Test
	public void testGetX() {
		assertEquals(plot1.getX(),2);	
	}
	@Test
	public void testGetY() {
		assertEquals(plot1.getY(),2);	
	}
	@Test
	public void testGetWidth() {
		assertEquals(plot1.getWidth(),6);
	}
	
	@Test
	public void testEncompasses() {
		assertTrue(plot1.encompasses(plot2));
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot2.toString());	
		assertEquals("2,2,6,6",plot1.toString());	

	}
	@Test 
	public void testEquals() {
		assertTrue(plot3.equals(plot4));
		
	}

}
