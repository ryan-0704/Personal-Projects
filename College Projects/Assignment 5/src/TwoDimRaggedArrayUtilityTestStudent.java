
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {{1,2,3},
								   {4,5},
								   {6,7,8,9}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
		
	}
	@Test
	public void testGetColTotal() {
		assertEquals(11.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,2),.001);

	}
	@Test
	public void testGetHighestCol() {
		assertEquals(6.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,0),.001);

	}
    @Test
    public void testReadFile() {
        try {
            File file = new File("dataSet1.txt");

            double[][] expected = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0, 7.0, 8.0}
            };

            double[][] result = TwoDimRaggedArrayUtility.readFile(file);

            assertNotNull("The result should not be null", result);
            assertEquals("The number of rows should match", expected.length, result.length);

            for (int i = 0; i < expected.length; i++) {
                assertArrayEquals("Row " + i + " should match", expected[i], result[i], 0.001);
            }

        } catch (Exception e) {
            fail("An exception should not have occurred: " + e.getMessage());
        }
    }
    @Test
    public void testWriteToFile() {
        try {
            double[][] inputArray = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0},
                {6.0, 7.0, 8.0}
            };

            File outputFile = new File("testWriteToFileOutput.txt");

            TwoDimRaggedArrayUtility.writeToFile(inputArray, outputFile);

            String expectedContent = """
                1.0 2.0 3.0
                4.0 5.0
                6.0 7.0 8.0
                """;

            StringBuilder actualContent = new StringBuilder();
            Scanner scanner = new Scanner(outputFile);
            while (scanner.hasNextLine()) {
                actualContent.append(scanner.nextLine()).append("\n");
            }
            scanner.close();

            assertEquals("File content should match", expectedContent.trim(), actualContent.toString().trim());

        } catch (IOException e) {
            fail("An exception occurred during the test: " + e.getMessage());
        }
    }
    @Test
    public void testGetAverage() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);

    }
    @Test
    public void testGetTotal() {
		assertEquals(45.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
    }
    @Test
    public void testGetHighestInRow() {
		assertEquals(3.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,0),.001);

    }
    @Test
    public void testGetHighestInRowIndex() {
		assertEquals(2.0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,0),.001);

    	
    }
    @Test
    public void testGetLowestInRow() {
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,0),.001);

    }
    @Test
    public void testGetLowestInRowIndex() {
		assertEquals(0.0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,0),.001);

    }
    @Test
    public void testGetHighestInColumn() {
		assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,2),.001);

    }
    @Test
    public void testGetHighestInColumnIndex() {
		assertEquals(2.0,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,2),.001);

    }
    
    @Test
    public void testGetLowestInColumn() {
		assertEquals(3.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,2),.001);

    }
    @Test
    public void testGetLowestInColumnIndex() {
		assertEquals(0.0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,2),.001);

    }
    @Test
    public void testGetHighestInArray() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);

    }
    @Test
    public void testGetLowesrInArray() {
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);

    }
    
}
