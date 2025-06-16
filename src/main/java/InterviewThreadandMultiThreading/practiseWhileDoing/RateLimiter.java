package InterviewThreadandMultiThreading.practiseWhileDoing;

    import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

    public class RateLimiter {
        private final int maxTokens;       // Maximum tokens the bucket can hold
        private final int refillRate;     // Rate at which tokens are added (tokens/second)
        private int availableTokens;      // Current number of tokens in the bucket
        private final Object lock = new Object();

        public RateLimiter(int maxTokens, int refillRate) {
            this.maxTokens = maxTokens;
            this.refillRate = refillRate;
            this.availableTokens = maxTokens;

            // Schedule a task to refill tokens at a fixed rate
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(this::refillTokens, 0, 1, TimeUnit.SECONDS);
        }

        private void refillTokens() {
            synchronized (lock) {
                int newTokens = Math.min(maxTokens, availableTokens + refillRate);
                System.out.println("Refilled tokens: " + newTokens);
                availableTokens = newTokens;
            }
        }

        public boolean tryAcquire() {
            synchronized (lock) {
                if (availableTokens > 0) {
                    availableTokens--;
                    System.out.println(Thread.currentThread().getName() + " acquired a token. Remaining: " + availableTokens);
                    return true;
                } else {
                    System.out.println(Thread.currentThread().getName() + " denied: No tokens available.");
                    return false;
                }
            }
        }

        public static void main(String[] args) {
            int maxTokens = 5;       // Bucket size
            int refillRate = 2;      // Tokens added per second
            RateLimiter rateLimiter = new RateLimiter(maxTokens, refillRate);

            // Simulate client requests using threads
            Runnable clientTask = () -> {
                while (true) {
                    boolean success = rateLimiter.tryAcquire();
                    if (success) {
                        // Simulate request processing
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        // Retry after some time if request is denied
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            };

            // Create multiple client threads
            for (int i = 1; i <= 3; i++) {
                new Thread(clientTask, "Client-" + i).start();
            }
        }
    }


