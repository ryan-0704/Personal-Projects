
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
	ManagementCompany copy;
	ManagementCompany test;

	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Railey", "555555555",6);
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		second = new Property();
		third = new Property();
		test= new ManagementCompany("Supersational", "55555", 2614, 5,5,5,5);
		copy = new ManagementCompany(test);
//	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {

	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
		sampleProperty=null;
		test  = null;
		copy=null;
	}
	@Test
	public void testConstructor1(){
		assertEquals(mangementCo.getName(), "Railey");
		assertEquals(mangementCo.getTax(), "555555555");
		assertEquals(mangementCo.getFee(), 6);
		
	}
	@Test
	public void testConstructor2(){
		assertEquals(test.getName(), "Supersational");
		assertEquals(test.getTax(), "55555");
		assertEquals(test.getFee(), 2614);
		
		assertEquals(test.getPlot().getX(), 5);
		assertEquals(test.getPlot().getY(), 5);
		assertEquals(test.getPlot().getWidth(), 5);
		assertEquals(test.getPlot().getDepth(), 5);
		
		
	}
	@Test
	public void testConstructor3(){
		assertEquals(test.equals(copy), true );
		
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
	@Test
	public void testGetName() {
		assertEquals(test.getName(),"Supersational" );
		//		test= new Property("Supersational", "Becker", 2614, "Willy bilson", 5,5,5,5);
		//		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	


	}
	@Test
	public void testGetTax(){
		assertEquals(test.getTax(), "55555");
	}
	@Test
	public void testGetPlot(){
		assertEquals(test.getPlot(), test.getPlot());
	}
	@Test
	public void testGetProperties(){
		mangementCo.addProperty("Sunsational", "Beckman", 2613, "BillyBob Wilson",15,15,1,1);
		assertEquals(mangementCo.getProperties()[0].getCity(),"Beckman");
	}
	@Test
	public void testGetTotalRent(){
		assertEquals(test.getTotalRent(), 0.0);
	}
	@Test
	public void testRemoveLastProperty(){
		mangementCo.removeLastProperty();
		assertEquals(mangementCo.getProperties()[4], null);
	}
	@Test
	public void testIsPropertiesFull(){
		assertEquals(test.isPropertiesFull(), false);
	}
	@Test
	public void testGetHighestRent(){
		assertEquals(test.getHighestRentProperty(), test.getProperties()[0]);
	}
	@Test
	public void testIsManagementFeeValid(){
		assertEquals(test.isManagementFeeValid(), false);
	}
//	@Test
//	public void testGetPropertiesCount(){
//		assertEquals(test.getTax(), "55555");
//	}

	

	





	
	

}
