import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	@BeforeEach
	void setUp() {

	}

	@Test
	public void testCalcPrice() {

		Smoothie basicSmoothie = new Smoothie("Berry Basic", Size.SMALL, 0, false);
		assertEquals(2.0, basicSmoothie.calcPrice(), 0.01);

		Smoothie proteinSmoothie = new Smoothie("Protein Shake", Size.MEDIUM, 0, true);
		assertEquals(4.0, proteinSmoothie.calcPrice(), 0.01);

		Smoothie fruitySmoothie = new Smoothie("Triple Berry", Size.LARGE, 3, false);
		assertEquals(4.5, fruitySmoothie.calcPrice(), 0.01);

		Smoothie deluxeSmoothie = new Smoothie("Ultimate", Size.LARGE, 4, true);
		assertEquals(6.5, deluxeSmoothie.calcPrice(), 0.01);
	}

	@Test
	public void testEquals() {
		Smoothie smoothie1 = new Smoothie("Berry Blast", Size.MEDIUM, 2, true);
		Smoothie smoothie2 = new Smoothie("Berry Blast", Size.MEDIUM, 2, true);
		Smoothie smoothie3 = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
		Smoothie smoothie4 = new Smoothie("Berry Blast", Size.LARGE, 2, true);
		Smoothie smoothie5 = new Smoothie("Berry Blast", Size.MEDIUM, 2, false);

		assertTrue(smoothie1.equals(smoothie2));

		assertFalse(smoothie1.equals(smoothie3));

		assertFalse(smoothie1.equals(smoothie4));

		assertFalse(smoothie1.equals(smoothie5));
	}

	@Test
	public void testGetters() {
		Smoothie smoothie = new Smoothie("Test Smoothie", Size.MEDIUM, 3, true);

		assertEquals(3, smoothie.getNumOfFruits());
		assertTrue(smoothie.getAddProtein());
		assertEquals("Test Smoothie", smoothie.getBevName());
		assertEquals(Size.MEDIUM, smoothie.getSize());
	}

	@Test
	public void testToString() {
		Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 2, true);
		String expected = smoothie.toString();

		assertTrue(expected.contains("fruits=2"));
		assertTrue(expected.contains("protein=true"));
		assertTrue(expected.contains("Name=Berry Blast"));
		assertTrue(expected.contains("Size=MEDIUM"));
	}

}
