package InterviewThreadandMultiThreading.practiseWhileDoing;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlocksWithLock {
    public static void main(String[] args) {
        System.out.println("-----------------deadlock impl by usinf the basic codes-------------------------------------------");
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();


        Thread thread3 = new Thread(() -> {
            try {
                // Acquire lock1 and then lock2
                lock1.lock();
                System.out.println("Thread 1 acquired lock1");

                // Simulate some work
                Thread.sleep(100);

                lock2.lock();
                System.out.println("Thread 1 acquired lock2");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                // Acquire lock2 and then lock1
                lock2.lock();
                System.out.println("Thread 2 acquired lock2");

                // Simulate some work
                Thread.sleep(100);

                lock1.lock();
                System.out.println("Thread 2 acquired lock1");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        });

        thread3.start();
        thread4.start();


        //TPE execution
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(), )


    }



}
