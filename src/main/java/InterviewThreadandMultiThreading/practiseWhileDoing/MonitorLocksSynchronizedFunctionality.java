package InterviewThreadandMultiThreading.practiseWhileDoing;

public class MonitorLocksSynchronizedFunctionality {
    public synchronized void task1()  {
        System.out.println("inside task 1");
        try {
            Thread.sleep(10000); //measn no monitor lock is relased, but in waitin gor blocked state it relaease  the monitor lockt
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void task2(){
        System.out.println("inside task2, outside sync block");
        synchronized (this){
            System.out.println("task2, inside syncrnized block");
        }
    }

    public void task3(){
        System.out.println("inside task 3");
    }

    public static void main(String[] args) {
        MonitorLocksSynchronizedFunctionality monitorLocksSynchronizedFunctionality = new MonitorLocksSynchronizedFunctionality();
        Thread t1 = new Thread(()-> monitorLocksSynchronizedFunctionality.task1());
        Thread t2 = new Thread(()-> monitorLocksSynchronizedFunctionality.task2());
        Thread t3 = new Thread(()-> monitorLocksSynchronizedFunctionality.task3());

        t1.start();
        t2.start();
        t3.start();

        /**
            by executing this peice of code we do relaise that the lock
         is put on the object that isbeing called, not the methos
         but the object essentially, due to which even if the different
         method is called still you would end of waiting for the first thread
         to relase the monitor lock, that would essentially take up 10
         sec to relase and the your other thread will go inside the critical section
         to execute the rest of the statements in the task2
         but here the task3  will run right away even though the lock is
         there on object reason being that there is no critical section ie specified by your codes

         **/


    }
}
