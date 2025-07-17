public class Level2 {
	public static boolean whit_walkers(String village) {
    int countInt = 0;
    int[] digitPositions = new int[10];
    int equalCount = 0;

    for (int i = 0; i < village.length(); i++) {
        char currentChar = village.charAt(i);
        if (Character.isDigit(currentChar)) {
            int digit = Character.getNumericValue(currentChar);
            digitPositions[digit]++;
            countInt++;
        } else if (currentChar == '=') {
            equalCount++;
        }
    }

    if (countInt < 2 || countInt == 3) {
        return false;
    }

    for (int i = 0; i < 10; i++) {
        for (int j = i; j < 10; j++) {
            if (i + j == 10) {
                
                if (digitPositions[i] > 0 && digitPositions[j] > 0) {
                    
                    if (i == j && digitPositions[i] < 2) {
                        continue;
                    }
                    
                    if (equalCount >= 3) {
                        return true;
                    }
                }
            }
        }
    }

    return false;
	}