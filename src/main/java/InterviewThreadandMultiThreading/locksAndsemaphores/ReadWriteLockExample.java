package InterviewThreadandMultiThreading.locksAndsemaphores;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//producer- sonsumer type impl
public class ReadWriteLockExample {
    public static void main(String[] args) {
        SharedResourceForReadWrite sharedResourceForReadWrite = new SharedResourceForReadWrite();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Thread thread = new Thread(()->{
            sharedResourceForReadWrite.producer(readWriteLock);
        });

        Thread thread1 = new Thread(()->{
            sharedResourceForReadWrite.producer(readWriteLock);
        });

        SharedResourceForReadWrite sharedResourceForReadWrite1=  new SharedResourceForReadWrite();
        Thread thread2 = new Thread(()->{
            sharedResourceForReadWrite1.consumer(readWriteLock);
        });
        Thread thread3 = new Thread(()->{
            sharedResourceForReadWrite1.consumer(readWriteLock);
        });

        thread1.start();
        thread.start();
        thread2.start();
        thread3.start();
    }
}

class SharedResourceForReadWrite{
    boolean isAvailable = false;

    public void producer(ReadWriteLock lock){
        try {
            lock.readLock().lock();
            {
                System.out.println("above instrution");
//                boolean flag = is
                isAvailable = true;
                System.out.println("below instruction");
            }
            System.out.println("Read lock acquired by : " + Thread.currentThread().getName() );
            System.out.println("The values read by thread : " + Thread.currentThread().getName() + " is : " + isAvailable);
            Thread.sleep(1500);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by : " +  Thread.currentThread().getName());
        }
    }


    public void consumer(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            isAvailable =true;
            Thread.sleep(2000);
            System.out.println("Write Lock acuired by : "+ Thread.currentThread().getName() + " is : " + isAvailable);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by : " + Thread.currentThread().getName());
        }
    }
}

/**
 * Read lock acquired by : Thread-0
 * Read lock acquired by : Thread-1
 * The values read by thread : Thread-0 is : false
 * The values read by thread : Thread-1 is : false
 * Read lock released by : Thread-1
 * Read lock released by : Thread-0
 * Write Lock acuired by : Thread-2
 * Write lock released by : Thread-2
 */