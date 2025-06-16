package InterviewThreadandMultiThreading.practiseWhileDoing;

import java.time.Instant;

public class PrintEvensAndOddsFrom2Threads {
    public static void main(String[] args) throws InterruptedException {
        EvenOddPrinting evenOddPrinting = new EvenOddPrinting();
        System.out.println(System.currentTimeMillis());
        Thread thread = new Thread(()->{
            for(int i =0; i<5; i++){
                try {
                    evenOddPrinting.displayElementEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread1 = new Thread(()->{
            for(int i =0; i<5; i++){
                try {
                    evenOddPrinting.displayElementOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        thread1.start();
        thread1.join();
        thread.join();
        System.out.println(System.currentTimeMillis());

    }
}

class EvenOddPrinting{

    int item  = 1;

    public synchronized void displayElementEven() throws InterruptedException {

//        System.out.println("starting from start in even person");
        while(item%2 != 0){
//            System.out.println("waiting from even dsplay");
            wait();
        }
//        Thread.sleep(1000);
        System.out.println("Item printed by thread : " + Thread.currentThread().getName() + " is : " + item);
        item += 1;
        notify();
    }

    public synchronized  void displayElementOdd() throws InterruptedException {
//        System.out.println("starting from start in odd person");
        while(item%2 == 0){
//            System.out.println("waiting from odd display");
            wait();
        }

//        Thread.sleep(1000);
        System.out.println("Item printed by thread : " + Thread.currentThread().getName() + " is : " + item);
        item+= 1;
        notify();
    }

}
