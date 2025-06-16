package InterviewThreadandMultiThreading.practiseWhileDoing.printfromQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//print rom the 2 queues ,each thread has one , now print one by one
public class PrintFromQueue {


    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2=  new LinkedList<>();
        q1.offer(1);
        q1.offer(2);
        q2.offer(3);
        q2.offer(4);

        boolean turn = true;
        SharedResource sharedResource = new SharedResource();
        Thread thread = new Thread(()->{
            while (!q1.isEmpty()){
                int a = q1.poll();
                try {
                    sharedResource.displayMethod(a, turn);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread1 = new Thread(()->{
            while (!q2.isEmpty()){
                int a = q2.poll();
                try {
                    sharedResource.displayMethod( a, !turn);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread.start();
    }

    static class SharedResource {
        boolean flag = false;

        public synchronized void displayMethod(int a, boolean turn) throws InterruptedException {
            while(turn != flag){
                wait();
            }
            System.out.println("The current thread execiting is " +
                    Thread.currentThread().getName() + " the number printed is " + a);
            flag = !flag;
            notifyAll();
        }
    }
}
