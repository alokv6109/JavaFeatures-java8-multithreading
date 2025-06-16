package InterviewThreadandMultiThreading.practiseWhileDoing;

public class BasicTreads {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Runnable r1 = ()->{
            System.out.println(Thread.currentThread().getName());
            for(int i =0; i<10; i++){
                System.out.println("number printed : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable r2 = ()->{
            System.out.println(Thread.currentThread().getName());
            for(int i =1; i<=10; i++){
                System.out.println("table of 5 printed : " + i*5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(r1);
        Thread thread1 = new Thread(r2);
        thread.start();
        thread1.start();
        Thread thread2 = new MyThreadClass();
        thread2.start();
    }
}

class MyThreadClass extends Thread{



    public void run(){
        System.out.println("alok verma");

    }

}
