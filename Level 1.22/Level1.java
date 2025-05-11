public class Level1 {
    public static boolean SherlockValidString(String s) {
        int[] charCount = new int[26];
        
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                charCount[c - 'a']++;
            } else {
                return false;
            }
        }
        
        int[] freq = new int[s.length() + 1]; 
        
        for (int count : charCount) {
            if (count > 0) {
                freq[count]++;
            }
        }
        
        int uniqueCount = 0;
        int firstFreq = 0;
        int secondFreq = 0;

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
                if (uniqueCount == 1) {
                    firstFreq = i;
                } else if (uniqueCount == 2) {
                    secondFreq = i;
                }
            }
        }
        
        if (uniqueCount == 1) {
            return true;
        }
        
        if (uniqueCount > 2) {
            return false;
        }
        
        return (freq[firstFreq] == 1 && firstFreq == 1) ||
               (freq[secondFreq] == 1 && secondFreq == 1) ||
               (Math.abs(firstFreq - secondFreq) == 1 && 
                (freq[firstFreq] == 1 || freq[secondFreq] == 1));
    }
}
