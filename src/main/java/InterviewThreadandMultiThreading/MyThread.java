package InterviewThreadandMultiThreading;

public class MyThread implements Runnable {
//    public static void main(String[] args) {
//        MyThread obj = new MyThread();
//        Thread thread =new Thread(obj);
//        thread.start();
//    }

    @Override
    public void run() {
        for (int i=0;i<=20;i++){
            System.out.println("i= "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    
}
