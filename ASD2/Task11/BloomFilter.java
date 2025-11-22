public class BloomFilter
{
      public int filter_len;
      private int bitArray;

      public BloomFilter(int f_len)
      {
        filter_len = f_len;
        bitArray = 0;
      }
      private void setBit(int i) {
        bitArray |= (1 << i);
      }
      
      private boolean checkBit(int i) {
        return (bitArray & (1 << i)) != 0;
      }

      public int hash1(String str1)
      {
        if (str1 == null) {
        return 0;
      }

        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            hash = (hash * 17 + code) % filter_len;
        }
        if(hash > 0) {
          return hash;
        }
        return 0;
      }


      public int hash2(String str1)
      {
        {
          if (str1 == null) {
            return 0;
          } 

          int hash = 0;
            for(int i=0; i<str1.length(); i++)
            {
              int code = (int)str1.charAt(i);
              hash = (hash * 223 + code) % filter_len;
            }
          if(hash > 0) {
            return hash;
          }
          return 0;
        }
      }

      public void add(String str1)
      {
        int index1 = hash1(str1);
        int index2 = hash2(str1);
        
        setBit(index1);
        setBit(index2);
      }

      public boolean isValue(String str1)
      {
        int index1 = hash1(str1);
        int index2 = hash2(str1);

        if(checkBit(index1) && checkBit(index2)) {
          return true;
        }
        return false;
      }
}




