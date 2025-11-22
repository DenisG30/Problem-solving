import java.util.BitSet;
import java.util.Random;
import java.util.Arrays;

// Exercise No.2
public class BloomFilter {
    private BitSet bitSet;
    private int size;
    private int hashFun;
    private Random random;

    public BloomFilter(int size, int hashFun) {
        this.size = size;
        this.hashFun = hashFun;
        this.bitSet = new BitSet(size);
        this.random = new Random();
    }

    private int hash(String value, int seed) {
        random.setSeed(seed);
        return Math.abs(value.hashCode() + seed) % size;
    }

    public void add(String value) {
        for (int i = 0; i < hashFun; i++) {
            int index = hash(value, i);
            bitSet.set(index);
        }
    }

    public boolean contains(String value) {
        for (int i = 0; i < hashFun; i++) {
            int index = hash(value, i);
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    public static BloomFilter merge(BloomFilter filter1, BloomFilter filter2) {
        // filter1.size != filter2.size || filter1.hashFun != filter2.hashFun {
            

        BloomFilter mergedFilter = new BloomFilter(filter1.size, filter1.hashFun);
        mergedFilter.bitSet.or(filter1.bitSet);
        mergedFilter.bitSet.or(filter2.bitSet);
        
        return mergedFilter;
    }
}

// Exercise No.3
public class CountingBloomFilter {
    private int[] counts;
    private int size;
    private int hashFun;
    private Random random;

    public CountingBloomFilter(int size, int hashFun) {
        this.size = size;
        this.hashFun = hashFun;
        this.counts = new int[size];
        this.random = new Random();
    }

    private int hash(String value, int seed) {
        random.setSeed(seed);
        return Math.abs(value.hashCode() + seed) % size;
    }

    public void add(String value) {
        for (int i = 0; i < hashFun; i++) {
            int index = hash(value, i);
            counts[index]++;
        }
    }

    public void remove(String value) {
        for (int i = 0; i < hashFun; i++) {
            int index = hash(value, i);
            if (counts[index] > 0) {
                counts[index]--;
            }
        }
    }

    public boolean contains(String value) {
        for (int i = 0; i < hashFun; i++) {
            int index = hash(value, i);
            if (counts[index] == 0) {
                return false;
            }
        }
        return true;
    }
}

// Exercise No.4
public class BloomFilterRecovery {
    private BitSet bitSet;
    private int size;
    private int[] hashArr;

    public BloomFilterRecovery(int size, int hashFun) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashArr = new int[hashFun];
        Random rand = new Random();
        for (int i = 0; i < hashFun; i++) {
            hashArr[i] = rand.nextInt();
        }
    }

    private int hash(String value, int seed) {
        return Math.abs(value.hashCode() ^ seed) % size;
    }

    public void add(String value) {
        for (int seed : hashArr) {
            bitSet.set(hash(value, seed));
        }
    }

    public boolean contains(String value) {
        for (int seed : hashArr) {
            if (!bitSet.get(hash(value, seed))) {
                return false;
            }
        }
        return true;
    }

    public BitSet getBitSet() {
        return bitSet;
    }
}

/* 
    Рефлексия Задание №9 решение №5

    Решение из рекомендации понятно. Не понимаю, в чем ошибся, для рефлексии.
*/


