public class Level1 {
    public static int PrintingCosts(String line) {
       
        String table = """
                       (пробел) 0     !  9        "  6        #  24        $  29        %  22\r
                        &  24        '  3        (  12        )  12        *  17        +  13\r
                        ,  7         -  7         .  4         /  10        0  22        1  19\r
                        2  22        3  23        4  21        5  27        6  26        7  16\r
                        8  23        9  26        :  8        ;  11        <  10        =  14\r
                        >  10        ?  15        @  32        A  24        B  29        C  20\r
                        D  26        E  26        F  20        G  25        H  25        I  18\r
                        J  18        K  21        L  16        M  28        N  25        O  26\r
                        P  23        Q  31        R  28        S  25        T  16        U  23\r
                        V  19        W  26        X  18        Y  14        Z  22        [  18\r
                        \\  10       ]  18       ^  7         _  8         `  3         a  23\r
                        b  25        c  17        d  25        e  23        f  18        g  30\r
                        h  21        i  15        j  20        k  21        l  16        m  22\r
                        n  18        o  20        p  25        q  25        r  13        s  21\r
                        t  17        u  17        v  13        w  19        x  13        y  24\r
                        z  19        {  18        |  12        }  18        ~  9
                        """;
        
        String[] words = table.split("\\s{3,}");
        String [][] anybodyElem = new String[words.length][2];
        char[] elements = new char[words.length];
        int[] nums = new int[words.length];
        
        for (int i = 0; i < words.length; i++) {
            anybodyElem[i] = words[i].split("\\s+");
            if(anybodyElem[i][0].equals("(пробел)")) {
                elements[i] = ' ';
            } else {
                elements[i] = anybodyElem[i][0].charAt(0);
            }
            nums[i] = Integer.parseInt(anybodyElem[i][1]);
        }
 
        char[] lineArr = line.toCharArray();
        int sum = 0;
 
        for(int i = 0; i < lineArr.length; i++) {
            boolean space = false; 
            
            for(int j = 0; j < elements.length; j++) {
                if(lineArr[i] == elements[j]) {
                    sum += nums[j];
                    space = true; 
                    break; 
                }
            }
            
            if (!space) { 
                sum += 23;
            }
        }
        
        return sum;
    }
}
