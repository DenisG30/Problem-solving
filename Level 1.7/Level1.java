public class Level1 {
    public static int[]  WordSearch(int len, String s, String subs) {
        String[] words = s.split(" ");
        
        StringBuilder lineInNstr = new StringBuilder();
        StringBuilder nStr = new StringBuilder();

        for (String word : words) {
            if (word.length() > len) {
                if (lineInNstr.length() > 0) {
                    nStr.append(lineInNstr.toString()).append("\n");
                    lineInNstr.setLength(0);
                }
                for (int i = 0; i < word.length(); i += len) {
                    int end = Math.min(i + len, word.length());
                    nStr.append(word.substring(i, end)).append("\n");
                }
            } else {
                if (lineInNstr.length() + word.length() + 1 <= len) {
                    if (lineInNstr.length() > 0) {
                        lineInNstr.append(" ");
                    }
                    lineInNstr.append(word);
                } else {
                    nStr.append(lineInNstr.toString()).append("\n");
                    lineInNstr.setLength(0);
                    lineInNstr.append(word);
                }
            }
        }
        if (lineInNstr.length() > 0) {
            nStr.append(lineInNstr.toString());
        }
        
        words = nStr.toString().split("\n");
        
        int[] res = new int[words.length];
        
        for(int i = 0; i < words.length; i++){
            boolean answ = false;
            String str = words[i];
            String[] strWords = str.split(" ");
            
            for(String word : strWords) {
                if(word.equals(subs)) {
                    answ = true;
                    break;
                }
            }
            if(answ) {
                res[i] = 1;
            } else { 
                res[i] = 0;
            }
        }
        return res;
    }
}
