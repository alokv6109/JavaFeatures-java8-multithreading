package InterviewThreadandMultiThreading;

public class Main {
    public static void main(String[] args) {
        MyThread t1= new MyThread();
////        Runnable t2= new MyThread();
//        //start methid is not present with this t1 thread
//        //it is present with the class Thread of java.lang.Thread
//        //and hence an object of Thread needs to be oresent there
//        //and hence you need toi create one
//
        Thread thread = new Thread(t1); //we have given a target reference of the MyThread class whih is basicaly implementing the
//        // runnable functional interface
        thread.setName("Thread from runnable interface impl");
        System.out.println("the name of thread is : " + thread.getName());
//
        thread.start();
        
        
        //for the second thread using the other method of creation of the thred ie extending the thread class
//        //for this thread it will dorectly have the object of Mythread2 and it will not ask for the thread class to run it
//        //as the Thread exntended by this Class and hence the parent has the start method
//        //so nothing needs to be done extra just make the object oif the new thread and go ahead and start the method
//
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        // TODO:
        //create a new thread using the naonymous class
        //in this the thing is that you dont need to create anextra other class just for defining the task to be done in a thread
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //TODO: task in the run method of the thread
                System.out.println("this is teating thread");

            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.setName("alok thread");
        thread1.start();
        System.out.println("the infor about current thread is : " + Thread.currentThread());
        
        //TODO: now dong this creating a lambda expression
        Runnable runnable1=()->{
            System.out.println("this is done sing the lambda expression ! ayyo do you remember the basics of lambda");
        };
//        runnable1.run();
//        Thread.activeCount();
//        Thread thread = new Thread(runnable1);
//        thread.setName("lambda thread");
//        thread.start();

        System.out.println(Thread.activeCount());

//        System.out.println(Thread.enumerate(new Thread[]{thread, thread1}));

    }
}
