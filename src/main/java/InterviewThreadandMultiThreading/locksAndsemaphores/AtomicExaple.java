package InterviewThreadandMultiThreading.locksAndsemaphores;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExaple {
    public static void main(String[] args) throws InterruptedException {
        CounterExaple counterExaple = new CounterExaple();
        Thread thread = new Thread(()->{
            for(int i =0; i<200; i++){

                counterExaple.increment();
            }
        });
        Thread thread1 = new Thread(()->{
            for(int i =0; i<200; i++){

                counterExaple.increment();
            }
        });

        thread1.start();
        thread.start();

        thread.join();
        thread1.join();
        //join issliye qki varna seedha seedha sout ho jayega ie 0 fatafat khatam ho jayega hence


        System.out.println(counterExaple.get());
    }
}

class CounterExaple{
//    int counter  =0;
    AtomicInteger counter = new AtomicInteger(0);
//    incrementAndet will be usinf the CAS internally
    public  void increment(){
//        counter+=1;
        counter.incrementAndGet();
    }
    public int get(){
//        return counter;
        return counter.get();
    }
}