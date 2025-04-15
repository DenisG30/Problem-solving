public class Level1 {
    public static boolean LineAnalysis(String line) {
        char[] chars = line.toCharArray();
        int n = chars.length;

        if(n < 1) {
            return false;
        }

        if(n >= 1) {
            if (chars[0] != '*' || chars[n - 1] != '*') {
                return false;
            } 
        }

        String newString = "";
        for(int i = 0; i < n - 2; i++) {
            newString += chars[i + 1];
        }

        String[] patternsArr = newString.split("\\*");

        if (patternsArr.length == 0 || (patternsArr.length == 1 && patternsArr[0].isEmpty())) {
            return true;
        }
        int lenArr = patternsArr.length;
        int lenPattern = patternsArr[0].length();

        for(int i = 0; i < lenArr; i++) {
            if (patternsArr[i].length() != lenPattern) {
                return false;  
            }
        }
        return true;
    }
}
