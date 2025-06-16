package InterviewThreadandMultiThreading.practiseWhileDoing;

public class ExampleForDifferentLifecycleMethodsOfThread {
    public static void main(String[] args) {
        System.out.println("main method started ");
        ShardResource shardResource = new ShardResource();
        Thread producerThread = new Thread(()->{
            System.out.println("Producer Thread : "+ Thread.currentThread().getName());
            try {

                Thread.sleep(5000);
                shardResource.addItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consuer Thread : " + Thread.currentThread().getName());
            shardResource.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
        System.out.println("main ended");
    }
}

class ShardResource{
    boolean itemAvalilable = false;


    //sync puts the monitor lock on this method
    public synchronized void addItem(){
        itemAvalilable = true;
        System.out.println("Item added by thread : " + Thread.currentThread().getName() + " and invoking all threads to now consume it");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consume item method invoked by : " + Thread.currentThread().getName());
        //why while? sometime the thread ie waiting wakes up due to some noise, "suprius wake up" so you must check this again an again eho is waiting
        while(!itemAvalilable){
            try {
                System.out.println("Thread : " + Thread.currentThread().getName()  + " is waiting now !!");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Item consumed by : "+ Thread.currentThread().getName());
        itemAvalilable = false;
        notifyAll();
    }
}
