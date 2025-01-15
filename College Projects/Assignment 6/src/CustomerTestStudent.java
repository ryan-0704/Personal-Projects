import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: JUnit test for the Customer class
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ryan Jones
*/
public class CustomerTestStudent {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 25);
    }

    @Test
    public void testConstructor() {
        assertEquals("John Doe", customer.getName(), "Constructor did not set name correctly");
        assertEquals(25, customer.getAge(), "Constructor did not set age correctly");
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testSetName() {
        customer.setName("Jane Smith");
        assertEquals("Jane Smith", customer.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testSetAge() {
        customer.setAge(30);
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testToString() {
        String expected = "Customer [name=John Doe, age=25]";
        assertEquals(expected, customer.toString());
    }
}
