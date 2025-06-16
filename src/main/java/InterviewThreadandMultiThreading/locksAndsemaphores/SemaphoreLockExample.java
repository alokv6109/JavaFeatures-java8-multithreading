package InterviewThreadandMultiThreading.locksAndsemaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;

public class SemaphoreLockExample {
    public static void main(String[] args) {
        ResourceForSemaphoreLock resource =  new ResourceForSemaphoreLock();
        Thread thread = new Thread(()->{
            resource.producer();
        });

        Thread thread1 = new Thread(()->{
            resource.producer();
        });
        Thread thread2 = new Thread(()->{
            resource.producer();
        });
        Thread thread3 = new Thread(()->{
            resource.producer();
        });

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ResourceForSemaphoreLock{
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer(){
        try {
            lock.acquire();
            System.out.println("Read lock acquired by : " + Thread.currentThread().getName() );
            isAvailable = true;
            System.out.println("The values read by thread : " + Thread.currentThread().getName() + " is : " + isAvailable);
            Thread.sleep(4000);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.release();
            System.out.println("Read lock released by : " +  Thread.currentThread().getName());
        }
    }

}
