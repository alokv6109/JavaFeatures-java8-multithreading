package lambdaExpression;

public class ThreadDemoMain {

    public static void main(String[] args) {
        //first thread: John
        Runnable thread1 = ()-> {
            // TODO: 2/6/2023
            //for printin the stub
            for (int i =0;i<=5;i++){
                System.out.println("Value of i is " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t = new Thread(thread1);
        t.setName("John");
        t.start();

        //new thread
        Runnable thread2 = ()-> {
            try {
                for (int j=1;j<=5;j++){
                    System.out.println(j*2);
                    Thread.sleep(2000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Thread t2 = new Thread(thread2);
        t2.setName("Alok thread");
        t2.start();
    }
}
