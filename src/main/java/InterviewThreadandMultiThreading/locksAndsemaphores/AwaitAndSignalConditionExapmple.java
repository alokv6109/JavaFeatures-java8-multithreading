package InterviewThreadandMultiThreading.locksAndsemaphores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitAndSignalConditionExapmple {
    public static void main(String[] args) {
        SharedResourceForCondition condition = new SharedResourceForCondition();
        Thread thread = new Thread(() -> {
            condition.produce();
        });

        Thread thread1 = new Thread(()->{
            condition.consumeer();
        });

        thread.start();
        thread1.start();
    }
}
     class SharedResourceForCondition{
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition= reentrantLock.newCondition();
        boolean isVisible = false;

        public void produce(){
            try {
                reentrantLock.lock();
                if(isVisible == true){
                    condition.await();
                }
                isVisible = true;
                System.out.println("The item prouced by " + Thread.currentThread().getName() + " val is " + isVisible);
                condition.signalAll();

            }catch (Exception e){
                System.out.println("its anexception");
            }finally {
                reentrantLock.unlock();
//                condition.notifyAll();
            }
        }

        public  void consumeer(){
            try {
                reentrantLock.lock();
                if(isVisible == false){
                    condition.await();
                }
                isVisible = false;
                System.out.println("The item consumed by " + Thread.currentThread().getName() + " val is " + isVisible);
                condition.signalAll();

            }catch (Exception e){
                System.out.println("its anexception");
            }finally {
                reentrantLock.unlock();
//                condition.notifyAll();
            }
        }
    }

