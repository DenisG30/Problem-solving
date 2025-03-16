import org.junit.Test;
import static org.junit.Assert.*;

public class Level1Test {      
    @Test
    public void test() {
        assertEquals(1, Level1.squirrel(0)); // Factorial 0 = 1
        assertEquals(1, Level1.squirrel(1)); // Factorial 1 = 1
        assertEquals(2, Level1.squirrel(2)); // Factorial 2 = 2
        assertEquals(6, Level1.squirrel(3)); // Factorial 3 = 6
        assertEquals(3, Level1.squirrel(10)); // Factorial 10 = 3628800
    }
}

    