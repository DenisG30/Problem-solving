import java.util.HashMap;

public class Level2{
    public static boolean EEC_help(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : arr1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : arr2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        return map1.equals(map2);
    }
}