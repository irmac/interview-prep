import java.util.HashMap;
// LC importing hashmap

public class SimpleCache {
    // LC public class declaration

    private final int maxSize;
    // LC immutable number variable maxSize declaration which is only accessible in the class
    private final HashMap<String, String> cache;
    // LC hashmap cache declaration, with both keys and values as Strings.
    // LC the hashmap can be populated but not reassigned to another object because of the final keyword

    public StringCache(int maxSize) {
        //  LC public object constructor which takes in the maxSize variable
        //  LC no return type for the method indicated
        //  Question: should this be changed?
        this.maxSize = maxSize;
        // LC attaches a max size property to the Stringcache object which is populated with the maxsize variable
        this.cache = new HashMap<>(maxSize);
        // LC instantiates the hashmap as a property of the StringCache object
        // LC it seems inferred that this is the cache hashmap that is declared above rather than expressly stated
        // LC (maxSize) seems to give the hashmap a parameter of maxsize. 
        // Question: Can you give hashmaps parameters? Or is this a special thing?
    }

    public void put(String key, String value) {
        // ImL Check if the cache is full
        // LC public method which takes in 2 strings for key and value and gives no return
        if (cache.size() >= maxSize) {
            // LC checks the number of key value pairs in the cache and compares it with the maxSize
            // LC if the cache is bigger than the max we apply the following:
            // ImL Implement your cache eviction policy here
            // ImL For simplicity, we remove the first entry in this example
            String firstKey = cache.keySet().iterator().next();
            // LC keySet() gets all the keys in the hashmap
            // LC iterator().next() gets the first one that happens to come out
            cache.remove(firstKey);
            // LC removes the key value pair of firstKey from the cache to make space for a new key value pair
        }
        cache.put(key, value);
        // LC stores a new key value in the cache hashmap
    }

    public String get(String key) {
        // LC public method which returns a string and takes in a string
        return cache.get(key);
        // LC returns the value of the key that is presented to the cache
    }
