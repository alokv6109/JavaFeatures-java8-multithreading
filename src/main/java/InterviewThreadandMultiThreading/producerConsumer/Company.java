package InterviewThreadandMultiThreading.producerConsumer;

public class Company {

	int n;
	boolean flag = false;   // here false denotes that the producer has a chance to produce the resorce
//	if val is true then the consumer will work 
	synchronized public void produceItem(int n) throws InterruptedException {  //here the sync keyword is taking into consideration that the singl tread is using the thread and no one
//		elkse thread is using it , one tread at a time , so doung tat and takin that into accoubt
		if(flag) {
			wait();
		}
		this.n = n;
		System.out.println("produced : " + this.n);
		flag = true; //revrse the value ie there already 
		notify();
	}
	
	synchronized public int consumeItem() throws InterruptedException {
		if(!flag) { //there is chance of the flag is true and the flag is false, ie produceer will work
			wait();
		}
		System.out.println("consumed : " + this.n);
		flag =false; //reveerse the value ie already there , if not in the if block that means that I'm going to get flag value true and hence reversed
		notify();
		return this.n;
		
	}
}
