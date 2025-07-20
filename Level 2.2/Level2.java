import java.util.HashMap;

public class Level2 {
    public static String GreenDigital(String col) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        int countOne = 0;
        int countZero = 0;
        int maxLength = 0;
        int initialIndex = -1;

        for (int i = 0; i < col.length(); i++) {
            if (col.charAt(i) == '1') {
                countOne++;
            } else {
                countZero++;
            }

            int diff = countOne - countZero;

            if (map.containsKey(diff)) {
                int previousIndex = map.get(diff);
                int length = i - previousIndex;
                
                if (length >= maxLength) {
                    maxLength = length;
                    initialIndex = previousIndex + 1;
                }
            } else {
                map.put(diff, i);
            }
        }

        if (maxLength > 0) {
            return col.substring(initialIndex, initialIndex + maxLength);
        } else {
            return "";
        }
        
    }
}