public class Level1 {
    public static boolean white_walkers(String village) {
        for (int i = 0; i < village.length() - 2; i++) {
            if (Character.isDigit(village.charAt(i))) {
                int firstNumber = Character.getNumericValue(village.charAt(i));
                int j = i + 1;
                int equalCount = 0;
                for(; j < village.length(); j++) {
                    if(village.charAt(j) == '=') {
                        equalCount++;
                    } else {
                        break;
                    }
                }  
                if (j < village.length() && Character.isDigit(village.charAt(j))) {
                    int secondNumber = Character.getNumericValue(village.charAt(j));
                    if (firstNumber + secondNumber == 10 && equalCount == 3) {
                        return true; 
                    }
                }
            }
        }
        return false; 
    }
}
