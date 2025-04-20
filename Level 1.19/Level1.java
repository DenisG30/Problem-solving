public class Level1 {
    public static String[] ShopOLAP(int N, String[] items){
        int value = 0;
        int[] numsItems = new int[N];
        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            String item = items[i];
            String name = item.split(" ")[0];
            int numItem = Integer.parseInt(item.split(" ")[1]);

            boolean presence = false;

            for (int j = 0; j < value; j++) {
                if (names[j].equals(name)) {
                    numsItems[j] += numItem; 
                    presence = true;
                    break;
                }
            }

            if (presence == false) {
                numsItems[value] = numItem;
                names[value] = name;
                value++;
            }
        }

        for (int i = 0; i < value - 1; i++) {
            for (int j = i + 1; j < value; j++) {
                if (numsItems[i] < numsItems[j] || 
                    (numsItems[i] == numsItems[j] && names[i].compareTo(names[j]) > 0)) {
                    // Меняем местами
                    int tempQuantity = numsItems[i];
                    numsItems[i] = numsItems[j];
                    numsItems[j] = tempQuantity;

                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                }
            }
        }

        String[] res = new String[value];
        for (int i = 0; i < value; i++) {
            res[i] = names[i] + " " + numsItems[i];
        }

        return res;
    }         
}
