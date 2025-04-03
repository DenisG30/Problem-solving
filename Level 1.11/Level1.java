public class Level1 {
    public static String BigMinus(String s1, String s2) {
       
        int lenIntOne = s1.length();
        int lenIntTwo = s2.length();

        boolean majorInt = true;
        int take = 0;
        String res = "";

        if(lenIntOne == lenIntTwo) { 
            for(int i = 0; i < lenIntOne; i++) {
                int digit1 = s1.charAt(i) - '0';
                int digit2 = s2.charAt(i) - '0';

                if(digit1 == digit2) {
                    
                } else {
                    if(digit1 > digit2) {
                        majorInt = true;
                    } else {
                        majorInt = false;
                    }
                    break;
                }
            }

            if(majorInt) { 
                for(int i = 0; i < lenIntOne; i++) {
                    
                    int digit1 = s1.charAt(lenIntOne - 1 - i) - '0';
                    int digit2 = s2.charAt(lenIntTwo - 1 - i) - '0';
                    int diff = 0; 

                    if(digit1 < digit2 && i <= lenIntOne - 1) {
                        diff = digit1 + 10 - digit2 - take;
                        take = 0;
                        take += 1;
                        
                        
                    } else {
                        diff = digit1 - digit2 - take;
                        take = 0;
                        
                    }       
                    res = res + diff;
                }

            } else { 
                for(int i = 0; i < lenIntTwo; i++) {
                    
                    int digit1 = s1.charAt(lenIntOne - 1 - i) - '0';
                    int digit2 = s2.charAt(lenIntTwo - 1 - i) - '0';
                    int diff = 0; 

                    if(digit2 < digit1 && i <= lenIntTwo - 1) {
                        diff = digit2 + 10 - digit1 - take;
                        take = 0;
                        take += 1;         
                        
                    } else {
                        diff = digit2 - digit1 - take;
                        take = 0;
                        
                    }
                    
                    res = res + diff;
                }
            }
            String end = "";
            int lenRes = res.length();
                
            for(int i = 0; i < lenRes; i++) {
                end += res.charAt(lenRes - 1 - i);
                
            }   
            
            end = end.replaceFirst("^0+", "");
            
            if (end.isEmpty()) {
                end = "0";
            }
        
            return end;

            
        } else {
            if(lenIntOne > lenIntTwo) {
                for(int i = 0; i < lenIntOne; i++) {
                    
                    int digit1 = s1.charAt(lenIntOne - 1 - i) - '0';
                    int digit2;
                    
                    if (i < lenIntTwo) {
                        digit2 = s2.charAt(lenIntTwo - 1 - i) - '0';
                    } else {
                        digit2 = 0; 
                    }

                    int diff = 0; 

                    if(digit1 < digit2 && i <= lenIntOne - 1) {
                        diff = digit1 + 10 - digit2 - take;
                        take = 0;
                        take += 1;
                        
                        
                    } else {
                        diff = digit1 - digit2 - take;
                        take = 0;
                    }
                    res = res + diff;
                }

            } else {
                for(int i = 0; i < lenIntTwo; i++) {
                    int digit2 = s2.charAt(lenIntTwo - 1 - i) - '0';
                    int diff = 0;
                    int digit1;

                    if (i < lenIntOne) {
                        digit1 = s1.charAt(lenIntOne - 1 - i) - '0';
                    } else {
                        digit1 = 0; 
                    }

                    
                    if(digit2 < digit1 && i <= lenIntTwo - 1) {
                        diff = digit2 + 10 - digit1 - take;
                        take = 0;
                        take += 1;
                        
                    } else {
                        diff = digit2 - digit1 - take;
                        take = 0;
                        
                    }
                    
                    res = res + diff;
                }
            }
            String end = "";
            int lenRes = res.length();
                
            for(int i = 0; i < lenRes; i++) {
                end += res.charAt(lenRes - 1 - i);
            }
            
            end = end.replaceFirst("^0+", "");
                
            
            if (end.isEmpty()) {
                end = "0";
            }
            return end;
        }
    }
}
