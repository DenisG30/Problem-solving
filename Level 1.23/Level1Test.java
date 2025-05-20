import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    
public class Level1Test {

    @Test
    public void testTreeOfLife_SimpleTest() {
        String[] input = {
            "...."
        };
        String[] expected = {
            "++++"
        };
        String[] result = Level1.TreeOfLife(1, 4, 1, input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTreeOfLife_SimpleTest_Delete() {
        String[] input = {
            "++++"
        };
        String[] expected = {
            "...."
        };
        String[] result = Level1.TreeOfLife(1, 4, 2, input);
        assertArrayEquals(expected, result);
    }

    
    @Test
    public void testTreeOfLife_After_One_Year() {
        String[] input = {
            ".+..",
            "..+.",
            ".+.."
        };
        String[] expected = {
            "++++",
            "++++",
            "++++"
        };
        String[] result = Level1.TreeOfLife(3, 4, 1, input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTreeOfLife_After_Two_Year() {
        String[] input = {
            ".+..",
            "..+.",
            ".+.."
        };
        String[] expected = {
            "...+",
            "+...",
            "...+"
        };
        String[] result = Level1.TreeOfLife(3, 4, 2, input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTreeOfLife_After_Six_Year() {
        String[] input = {
            ".+..",
            "..+.",
            ".+.."
        };
        String[] expected = {
            "...+",
            "+...",
            "...+"
        };
        String[] result = Level1.TreeOfLife(3, 4, 6, input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTreeOfLife_After_Nine_Year() {
        String[] input = {
            ".+..",
            "..+.",
            ".+.."
        };
        String[] expected = {
            "++++",
            "++++",
            "++++"
        };
        String[] result = Level1.TreeOfLife(3, 4, 9, input);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testTreeOfLife_After_Twelve_Year() {
        String[] input = {
            ".+..",
            "..+.",
            ".+.."
        };
        String[] expected = {
            ".+..",
            "..+.",
            ".+.."
        };
        String[] result = Level1.TreeOfLife(3, 4, 12, input);
        assertArrayEquals(expected, result);
    }
}
