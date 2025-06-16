package InterviewThreadandMultiThreading.practiseWhileDoing;

public class DeamonThreadExample {
    public static void main(String[] args) {
        ThreadJoinClass threadJoinClass = new ThreadJoinClass();
        System.out.println("main thread started : " +Thread.currentThread().getName());
        Thread thread = new Thread(()->{
            System.out.println("Thread1 calling produce method");
            threadJoinClass.produce();
        });
        //used in gabage collector
//        autosave thread
//        logging
        thread.setDaemon(true);
        thread.start();

//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("main ended");

    }
}
