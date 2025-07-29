import java.util.HashMap;

public class Level2 {
    public static int massdriver(int[] activate) {
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for (int currentElement : activate) {
            map.put(currentElement, map.getOrDefault(currentElement, 0) + 1);
        }

        for (int i = 0; i < activate.length; i++) {
            if (map.get(activate[i]) > 1) {
                return i; 
            }
        }

        return -1; 
    }
}