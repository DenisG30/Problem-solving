import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import org.junit.Before;    
    
public class BloomFilterTest {
    BloomFilter bloomFilter = new BloomFilter(32);

    @BeforeEach
    public void setup(){
         
    }
        
    @Test
    public void testString() {
        String[] testStrings = {
            "0123456789", "1234567890", "2345678901",
            "3456789012", "4567890123", "5678901234",
            "6789012345", "7890123456", "8901234567",
            "9012345678"
        };

        String[] testStrings2 = {
            "0123586789", "1234543490", "2345676601",
            "3453489012", "4523896593", "1118901234",
            "6784532345", "3430123456", "8934124567",
            "9012555578"
        };

        for (String str : testStrings) {
            bloomFilter.add(str);
        }

        for (String str : testStrings) {
            assertTrue(bloomFilter.isValue(str));
        }

        for (String str : testStrings2) {
            assertFalse(bloomFilter.isValue(str));
        }
    }
}
    
