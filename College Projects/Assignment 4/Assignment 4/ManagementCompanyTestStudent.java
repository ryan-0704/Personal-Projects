
/**
 * This class represents GFA test cases for a ManagementCompany object.
 * 
 * @author Ryan Jones
 * @version 11/2/2024
 * 
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	Property testproperty;
	Property second;
	Property third;

	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Railey", "555555555",6);
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		second = new Property();
		third = new Property();

	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
		sampleProperty=null;
	}

	@Test
	public void testAddProperty() {
		testproperty=null;
		
	
		assertEquals(mangementCo.addProperty("Sunsational", "Beckman", 2613, "BillyBob Wilson",15,15,1,1),-3,0);	//property has been successfully added to index 0

		assertEquals(mangementCo.addProperty(sampleProperty),1,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty(sampleProperty),2,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty(sampleProperty),3,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty(sampleProperty),4,0);	//property has been successfully added to index 0
		assertEquals(mangementCo.addProperty(sampleProperty),-1,0);	//property has been successfully added to index 0




		assertEquals(mangementCo.addProperty(testproperty),-2,0);	//property has been successfully added to index 0

	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613.0, "BillyBob Wilson",2,5,2,2);
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 156.78";
		System.out.println(expectedString);
		System.out.println(mangementCo.toString());
		assertEquals(expectedString, mangementCo.toString());
				
	}
	

}
