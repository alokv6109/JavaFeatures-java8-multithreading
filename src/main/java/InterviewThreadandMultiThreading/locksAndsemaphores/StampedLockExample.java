package InterviewThreadandMultiThreading.locksAndsemaphores;

import java.time.LocalTime;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    public static void main(String[] args) {
        SharedResourceForStamped sharedResourceForStamped = new SharedResourceForStamped();
//        Thread thread = new Thread(()->{
//            sharedResourceForStamped.producer();
//        });
//
//        Thread thread1 = new Thread(()->{
//            sharedResourceForStamped.producer();
//        });
//
//        Thread thread2 = new Thread(()->{
//            sharedResourceForStamped.consumer();
//        });
//        thread1.start();
//        thread.start();
//        thread2.start();

        SharedResourceForOptimisticResource sharedResourceForOptimisticResource = new SharedResourceForOptimisticResource();
        Thread thread3= new Thread(()->{
            sharedResourceForOptimisticResource.producer();
        });

        Thread thread4 = new Thread(()->{
            sharedResourceForOptimisticResource.consumer();
        });

        thread3.start();
        thread4.start();
    }
}

class SharedResourceForStamped{
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();
    ReentrantLock reentrantLock = new ReentrantLock();
//    exeriment with 2 locks as well
    public void producer(){
        long stamp = lock.readLock();
        System.out.println("after read lock");
        reentrantLock.lock();
        try {
            System.out.println("Read lock acquired by : " + Thread.currentThread().getName() + " at " + LocalTime.now());
            System.out.println("The values read by thread : " + Thread.currentThread().getName() + " is : " + isAvailable);
            Thread.sleep(4000);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.unlockRead(stamp);
            reentrantLock.unlock();
            System.out.println("Read lock released by : " +  Thread.currentThread().getName());
        }
    }


    public void consumer(){
        long l=  lock.writeLock();

        try {

            System.out.println("Write Lock acuired by : "+ Thread.currentThread().getName());
            isAvailable =false;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.unlockWrite(l);
            System.out.println("Write lock released by : " + Thread.currentThread().getName());
        }
    }
}

class SharedResourceForOptimisticResource{
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();

    public void producer(){
        System.out.println("the reading is done by " + Thread.currentThread().getName());
        long stamp = lock.tryOptimisticRead();
        System.out.println("after read : "+ stamp);
        try {
            System.out.println("Read lock acquired by : " + Thread.currentThread().getName() );
            isAvailable = true;
            Thread.sleep(4000);
            if(lock.validate(stamp)){
                System.out.println("updated a value successfully ");
            }else{
                System.out.println("rollback of work");
                isAvailable = false;
            }
            System.out.println("The values read by thread : " + Thread.currentThread().getName() + " is : " + isAvailable);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void consumer(){
        long l=  lock.writeLock();
        System.out.println("after wite " + l);
        try {
            System.out.println("Write Lock acuired by : "+ Thread.currentThread().getName());
            isAvailable =false;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.unlockWrite(l);
            System.out.println("Write lock released by : " + Thread.currentThread().getName());
        }
    }
}



