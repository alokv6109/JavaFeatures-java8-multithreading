package InterviewThreadandMultiThreading.practiseWhileDoing;


    import java.util.concurrent.locks.ReentrantLock;

    public class DiningPhilosophers {
        private static final int NUM_PHILOSOPHERS = 5;

        public static void main(String[] args) {
            // Create forks as ReentrantLocks
            ReentrantLock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];
            for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
                forks[i] = new ReentrantLock();
            }

            // Create and start philosopher threads
            Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
            for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % NUM_PHILOSOPHERS]);
                new Thread(philosophers[i]).start();
            }
        }

        static class Philosopher implements Runnable {
            private final int id;
            private final ReentrantLock leftFork;
            private final ReentrantLock rightFork;

            public Philosopher(int id, ReentrantLock leftFork, ReentrantLock rightFork) {
                this.id = id;
                this.leftFork = leftFork;
                this.rightFork = rightFork;
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        // Think
                        think();

                        // Pick up left fork
                        leftFork.lock();
                        System.out.println("Philosopher " + id + " picked up left fork.");

                        // Pick up right fork
                        rightFork.lock();
                        System.out.println("Philosopher " + id + " picked up right fork.");

                        // Eat
                        eat();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        // Put down right fork
                        rightFork.unlock();
                        System.out.println("Philosopher " + id + " put down right fork.");

                        // Put down left fork
                        leftFork.unlock();
                        System.out.println("Philosopher " + id + " put down left fork.");
                    }
                }
            }

            private void think() throws InterruptedException {
                System.out.println("Philosopher " + id + " is thinking.");
                Thread.sleep((int) (Math.random() * 1000));
            }

            private void eat() throws InterruptedException {
                System.out.println("Philosopher " + id + " is eating.");
                Thread.sleep((int) (Math.random() * 1000));
            }
        }
    }

