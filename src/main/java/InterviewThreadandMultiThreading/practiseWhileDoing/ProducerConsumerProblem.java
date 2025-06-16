package InterviewThreadandMultiThreading.practiseWhileDoing;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        ResourceForProduction sharedResource = new ResourceForProduction(4);

        Thread producerThread = new Thread(()->{
            for(int i =1; i<=6; i++){
                try {
                    sharedResource.produceItem(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(()->{
            try {
                for (int i =1; i<= 6; i++){
                    sharedResource.consumeItem();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        producerThread.start();
        consumerThread.start();

    }

}

class ResourceForProduction{
    private Queue<Integer> q;
    private int bufferSize;


    public ResourceForProduction(int bufferSize){
        this.bufferSize = bufferSize;
        this.q = new LinkedList<>();
    }

    public synchronized void produceItem(int item) throws InterruptedException {
        if(q.size() == bufferSize){
            System.out.println("Buffer is full, Producer is waiting for the consumer");
            wait();
        }
        q.add(item);
        System.out.println("Produced the item : " + item);
        notify();
    }

    public synchronized int consumeItem() throws InterruptedException {
        while (q.isEmpty()){
            System.out.println("Buffer is empty , consumer is waiting for the producer");
            wait();
        }
        int item = q.poll();
        System.out.println("Consumed : " + item);
        notify();
        return item;
    }
}
