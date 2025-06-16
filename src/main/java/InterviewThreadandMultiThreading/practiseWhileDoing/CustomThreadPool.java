package InterviewThreadandMultiThreading.practiseWhileDoing;


    import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

    public class CustomThreadPool {
        private final BlockingQueue<Runnable> taskQueue; // Task queue
        private final WorkerThread[] workerThreads;      // Worker threads
        private volatile boolean isStopped = false;      // Flag to stop the pool

        // Constructor
        public CustomThreadPool(int numThreads) {
            taskQueue = new LinkedBlockingQueue<>();
            workerThreads = new WorkerThread[numThreads];

            for (int i = 0; i < numThreads; i++) {
                workerThreads[i] = new WorkerThread(taskQueue);
                workerThreads[i].start(); // Start each worker thread
            }
        }

        // Submit a task to the thread pool
        public void submit(Runnable task) {
            if (!isStopped) {
                taskQueue.offer(task); // Add task to the queue
            } else {
                throw new IllegalStateException("ThreadPool is stopped.");
            }
        }

        // Gracefully stop the thread pool
        public void shutdown() {
            isStopped = true;

            // Interrupt each worker thread
            for (WorkerThread worker : workerThreads) {
                worker.stopWorker();
            }
        }

        // Worker thread class
        private static class WorkerThread extends Thread {
            private final BlockingQueue<Runnable> taskQueue;
            private volatile boolean isStopped = false;

            public WorkerThread(BlockingQueue<Runnable> taskQueue) {
                this.taskQueue = taskQueue;
            }

            @Override
            public void run() {
                while (!isStopped ) {
//                    System.out.println(taskQueue.size());
                    try {
                        Runnable task = taskQueue.take(); // Retrieve the next task
                        task.run(); // Execute the task
                    } catch (InterruptedException e) {
                        // Handle thread interruption gracefully
                        Thread.currentThread().interrupt();
                    }
                }
            }

            // Stop the worker thread
            public void stopWorker() {
                isStopped = true;
                this.interrupt(); // Interrupt the thread if it's waiting
            }
        }

        // Main method to demonstrate the custom thread pool
        public static void main(String[] args) {
            CustomThreadPool threadPool = new CustomThreadPool(3); // Create a pool with 3 threads

            // Submit some tasks
            for (int i = 1; i <= 10; i++) {
                final int taskId = i;
                threadPool.submit(() -> {
                    System.out.println("Task " + taskId + " is being executed by thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500); // Simulate task execution
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

            // Shutdown the pool
            threadPool.shutdown();
        }
    }


