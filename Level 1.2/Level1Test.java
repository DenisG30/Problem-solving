import org.junit.Test;
import static org.junit.Assert.*;  
    
public class Level1Test {      
    @Test
    public void testOne() {
        int [] arr1 = {10, 1, 20, 2};
        assertEquals(30, Level1.odometer(arr1));  
    }

    @Test
    public void testTwo() {
        int [] arr2 = {10, 1, 20, 2, 30, 5, 50, 8};
        assertEquals(270, Level1.odometer(arr2)); 
    }

    @Test
    public void testOfThreeEements() {
        int [] arr3 = {10, 1, 20};
        assertEquals(10, Level1.odometer(arr3));  
    }

    @Test
    public void testOfFiveEements() {
        int [] arr4 = {10, 1, 20, 2, 50};
        assertEquals(10, Level1.odometer(arr4));  
    }
}
    