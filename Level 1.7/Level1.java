public class Level1 {
    public static int [] WordSearch(int len, String s, String subs) {
        String [] words = s.split("\s+");
        String nStr = "";
        int itemCount = len;

        for(int i = 0; i < words.length; i++) {
            if(words[i] != "") {
                if(words[i].length() <= itemCount) {
                    nStr += words[i];
                    itemCount -= words[i].length();
                    if(i + 1 < words.length) {
                        if(words[i + 1].length() <= itemCount - 1) {
                            nStr += " ";
                            itemCount -= 1;
                        } else {
                            nStr += "\n";
                            itemCount = len;
                        }
                    }
                } else {
                    int iteration = 0;
                    if(words[i].length() % len != 0 ){
                        iteration = words[i].length() / len + 1;
                    } else {
                        iteration = words[i].length() / len;
                    }
                    int countTransfer = 1;
                    int nItemCount = 0;
                    String nWord = ""; 
                    for(int j = 0; j < iteration; j++) {
                        if(j != iteration - 1) {
                            nWord = words[i].substring(nItemCount, countTransfer * len);
                            nStr += nWord;
                            nStr += "\n";
                            nItemCount += len;
                        } else {
                            nWord = words[i].substring(words[i].length() - (words[i].length() % len));
                            nStr += nWord;
                            itemCount -= nWord.length();
                            if(i + 1 < words.length) {
                                if(words[i + 1].length() <= itemCount) {
                                    nStr += " ";
                                    itemCount -= 1;
                                } else {
                                    nStr += "\n";
                                    itemCount = len;
                                }
                            }
                        }   
                        countTransfer ++;
                    }
        
                }
            }
        }
        
        words = nStr.split("\\n");
        int[] res = new int[words.length];
        int subsLength = subs.length();

        for(int i = 0; i < words.length; i++){
            int wordLength = words[i].length();  
            if(wordLength < subsLength) {
                res[i] = 0;
                continue;
            }     
            
            for (int p = 0; p < wordLength; p++) {
                int j;
                for (j = 0; j < subsLength; j++) {
                    if (words[i].charAt(p + j) != subs.charAt(j)) {
                        if(p < wordLength)
                        break; 
                    }
                }
                
                if (j == subsLength) {
                    boolean startVal = (p == 0 || words[i].charAt(p - 1) == ' ');
                    boolean endVal = (p + subsLength == wordLength || words[i].charAt(p + subsLength) == ' ');
                    if(startVal && endVal){
                        res[i] = 1;
                    }
                }
            }
        } 
        return res;
    }
}
