package InterviewThreadandMultiThreading.practiseWhileDoing;

public class TreadJoinExample {
    public static void main(String[] args) {
        ThreadJoinClass threadJoinClass = new ThreadJoinClass();
        System.out.println("main thread started : " +Thread.currentThread().getName());
        Thread thread = new Thread(()->{
            System.out.println("Thread1 calling produce method");
//            Thread thread1 = new Thread(()->{
//                System.out.println("lalaa");
//            });
//            thread1.start();
            threadJoinClass.produce();
        });
        thread.start();
//        System.out.println("main thread ended");

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main ended");
    }
}

class ThreadJoinClass{
    boolean isAvailable = false;

    public synchronized void produce(){
        System.out.println("Lock Acquired by thread : " + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock released by thread : " + Thread.currentThread().getName());
    }
}

