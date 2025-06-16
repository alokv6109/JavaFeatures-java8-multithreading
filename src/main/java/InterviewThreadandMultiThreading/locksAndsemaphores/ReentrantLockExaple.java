package InterviewThreadandMultiThreading.locksAndsemaphores;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExaple {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //basically even when 2 resources are there having the same lock , they are still like going one by one only
        SharedResourceLockExample lockExample = new SharedResourceLockExample();
        Thread thread = new Thread(()->{
            lockExample.produce(lock);
        });

        SharedResourceLockExample lockExample1= new SharedResourceLockExample();
        Thread thread1 = new Thread(()->{
            lockExample1.produce(lock);
        });

        thread.start();
        thread1.start();

    }
}

class SharedResourceLockExample{
    boolean isAvailable = false;
//    ReentrantLock reentrantLock = new ReentrantLock();
    public void produce(ReentrantLock reentrantLock){

        try {
            reentrantLock.lock();
            System.out.println("Lock Acquired by thread : " + Thread.currentThread().getName());
            isAvailable =true;
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
            System.out.println("Lock released by thread : " + Thread.currentThread().getName());
        }
    }
}
