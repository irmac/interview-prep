import java.util.HashMap;

public class SimpleCache {
    private final int maxSize;
    private final HashMap<String, String> cache;

    public StringCache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new HashMap<>(maxSize);
    }

    public void put(String key, String value) {
        // Check if the cache is full
        if (cache.size() >= maxSize) {
            // Implement your cache eviction policy here
            // For simplicity, we remove the first entry in this example
            String firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }
