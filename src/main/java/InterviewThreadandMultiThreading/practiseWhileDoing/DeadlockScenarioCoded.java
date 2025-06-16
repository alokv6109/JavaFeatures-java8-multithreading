package InterviewThreadandMultiThreading.practiseWhileDoing;

import java.time.LocalTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockScenarioCoded {
    public static void main(String[] args) throws InterruptedException {
        DeadLockExample lockExample = new DeadLockExample();
        System.out.println("main thread started : " +Thread.currentThread().getName());
        Thread thread = new Thread(()->{
            System.out.println("Thread1 calling produce method at time : " + LocalTime.now());
            try {
                lockExample.cs1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread1 =new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread2 calling produce method at time : "+ LocalTime.now());
            lockExample.produce();
        });

        thread.start();
        thread1.start();
//        System.out.println("main thread ended");
//        System.out.println(LocalTime.now());

        Thread.sleep(200);
        thread.suspend();
        Thread.sleep(3000);
        System.out.println(LocalTime.now());
//        thread.resume();
        System.out.println("main ended");

    }
}

class DeadLockExample{
    boolean isAvailable = false;

    public synchronized void produce(){
//        int a = 43;
        System.out.println("Lock Acquired by thread : " + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(8000);
//            System.out.println();
            System.out.println("i am awake at " + LocalTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock released by thread : " + Thread.currentThread().getName());
    }

    public  synchronized  void cs1() throws InterruptedException {
        for(int i = 0; i<10; i++){
            System.out.println(i);
            Thread.sleep(100);
        }
    }

}


