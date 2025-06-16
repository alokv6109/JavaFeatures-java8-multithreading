package InterviewThreadandMultiThreading.practiseWhileDoing;

    import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

    public class ThreadSafeCache<K, V> {
        private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
        private final ConcurrentHashMap<K, Long> expiryMap = new ConcurrentHashMap<>();
        private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Constructor to start the cleaner thread
        public ThreadSafeCache() {
            scheduler.scheduleAtFixedRate(this::cleanUp, 1, 1, TimeUnit.SECONDS);
        }

        // Add an item to the cache with a TTL (time-to-live) in milliseconds
        public void put(K key, V value, long ttlMillis) {
            long expiryTime = System.currentTimeMillis() + ttlMillis;
            cache.put(key, value);
            expiryMap.put(key, expiryTime);
        }

        // Retrieve an item from the cache
        public V get(K key) {
            Long expiryTime = expiryMap.get(key);

            // Check if the item has expired
            if (expiryTime == null || expiryTime < System.currentTimeMillis()) {
                remove(key); // Remove expired item
                return null;
            }

            return cache.get(key);
        }

        // Remove an item from the cache
        public void remove(K key) {
            cache.remove(key);
            expiryMap.remove(key);
        }

        // Clean up expired items
        private void cleanUp() {
            long now = System.currentTimeMillis();
            for (K key : expiryMap.keySet()) {
                if (expiryMap.get(key) < now) {
                    remove(key);
                }
            }
        }

        // Shutdown the cache and scheduler
        public void shutdown() {
            scheduler.shutdown();
        }

        // Test the thread-safe cache
        public static void main(String[] args) throws InterruptedException {
            ThreadSafeCache<String, String> cache = new ThreadSafeCache<>();

            // Add items to the cache
            cache.put("key1", "value1", 3000); // Expires in 3 seconds
            cache.put("key2", "value2", 5000); // Expires in 5 seconds

            // Access items
            System.out.println("Get key1: " + cache.get("key1")); // Should return "value1"
            Thread.sleep(4000); // Wait 4 seconds

            // Access after expiry
            System.out.println("Get key1 after expiry: " + cache.get("key1")); // Should return null
            System.out.println("Get key2: " + cache.get("key2")); // Should return "value2"

            // Shutdown the cache
            cache.shutdown();
        }
    }


