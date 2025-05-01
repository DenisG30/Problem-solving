public class Level1 {
    public static String BiggerGreater(String input) {
        char[] chars = input.toCharArray();
        int n = chars.length;

        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i < 0) {
            return "";
        }

        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;


        int k = i + 1;
        int l = n - 1;

        while (k < l) {
            
            char arr = chars[k];
            chars[k] = chars[l];
            chars[l] = arr;
            k++;
            l--;
        }

        return new String(chars);
    }
}
