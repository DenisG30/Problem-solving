public class Level1 {
    public static boolean white_walkers(String village) {
        int countInt = 0;
        for (int i = 0; i < village.length(); i++) {
            if (Character.isDigit(village.charAt(i))) {
                countInt++;
            }
        }
        if (countInt < 2 || countInt == 3) {
            return false;
        }

        for (int i = 0; i < village.length(); i++) {
            if (Character.isDigit(village.charAt(i))) {
                int firstNumber = Character.getNumericValue(village.charAt(i));

                for (int j = i + 1; j < village.length(); j++) {
                    if (Character.isDigit(village.charAt(j))) {
                        int secondNumber = Character.getNumericValue(village.charAt(j));
                        int equalCount = 0;
                        for (int k = i + 1; k < j; k++) {
                            if (village.charAt(k) == '=') {
                                equalCount++;
                            }
                        }
                        if (firstNumber + secondNumber == 10 && equalCount == 3) {
                            return true;
                        }
                    }
                }

            }
        }
        return false; 
    }        
} 
