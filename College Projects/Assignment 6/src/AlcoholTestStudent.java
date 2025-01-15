import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
    public void testConstructor() {
        Alcohol drink1 = new Alcohol("Mojito", Size.SMALL, true);
        assertEquals("Mojito", drink1.getBevName());
        assertEquals(Size.SMALL, drink1.getSize());
        assertEquals(Type.ALCOHOL, drink1.getType());
        assertTrue(drink1.isWeekend());
        
        Alcohol drink2 = new Alcohol("Margarita", Size.LARGE, false);
        assertEquals("Margarita", drink2.getBevName());
        assertEquals(Size.LARGE, drink2.getSize());
        assertEquals(Type.ALCOHOL, drink2.getType());
        assertFalse(drink2.isWeekend());
        
        Alcohol drink3 = new Alcohol("", Size.MEDIUM, true);
        assertEquals("", drink3.getBevName());
        assertEquals(Size.MEDIUM, drink3.getSize());
        assertEquals(Type.ALCOHOL, drink3.getType());
        assertTrue(drink3.isWeekend());
    }
    

	@Test
    public void testCalcPrice() {
        Alcohol weekdaySmall = new Alcohol("Beer", Size.SMALL, false);
        assertEquals(2.0, weekdaySmall.calcPrice(), 0.01);
        
        Alcohol weekdayMedium = new Alcohol("Wine", Size.MEDIUM, false);
        assertEquals(2.5, weekdayMedium.calcPrice(), 0.01);
        
        Alcohol weekdayLarge = new Alcohol("Cider", Size.LARGE, false);
        assertEquals(3.0, weekdayLarge.calcPrice(), 0.01);
        
        Alcohol weekendSmall = new Alcohol("Beer", Size.SMALL, true);
        assertEquals(2.6, weekendSmall.calcPrice(), 0.01);
        
        Alcohol weekendMedium = new Alcohol("Wine", Size.MEDIUM, true);
        assertEquals(3.1, weekendMedium.calcPrice(), 0.01);
        
        Alcohol weekendLarge = new Alcohol("Cider", Size.LARGE, true);
        assertEquals(3.6, weekendLarge.calcPrice(), 0.01);
    }
    
    @Test
    public void testEquals() {
        Alcohol drink1 = new Alcohol("Beer", Size.MEDIUM, true);
        Alcohol drink2 = new Alcohol("Beer", Size.MEDIUM, true);
        Alcohol drink3 = new Alcohol("Beer", Size.MEDIUM, false);
        Alcohol drink4 = new Alcohol("Wine", Size.MEDIUM, true);
        Alcohol drink5 = new Alcohol("Beer", Size.LARGE, true);
        
        assertTrue(drink1.equals(drink2));
        
        assertFalse(drink1.equals(drink3));
        
        assertFalse(drink1.equals(drink4));
        
        assertFalse(drink1.equals(drink5));
    }
    
    @Test
    public void testWeekendGetterSetter() {
        Alcohol drink = new Alcohol("Beer", Size.MEDIUM, false);
        assertFalse(drink.isWeekend());
        
        drink.setWeekend(true);
        assertTrue(drink.isWeekend());
        
        drink.setWeekend(false);
        assertFalse(drink.isWeekend());
    }
    
    @Test
    public void testToString() {
        Alcohol drink = new Alcohol("Beer", Size.MEDIUM, true);
        String result = drink.toString();
        
        assertTrue(result.contains("weekend=true"));
        assertTrue(result.contains("Name=Beer"));
        assertTrue(result.contains("Size=MEDIUM"));
        assertTrue(result.contains("Price="));
    }

}
