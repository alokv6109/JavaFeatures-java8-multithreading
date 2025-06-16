package InterviewThreadandMultiThreading.producerConsumer;

public class MainClient {
	
	//is there to start the producer and consumer threads and keep producing and consuming the resource
	public static void main(String[] args) {
	
		Company company = new Company();
		Producer producer = new Producer(company);
		Consumer consumer = new Consumer(company);
		consumer.start();
		producer.start();
		
		//there is an issue that some items are not even produced but are being sonsued and some items are produced even though they are not even consumed
//		so that is spme issue tere and hence we would want to have the inter process communication here between the threads
//		/so we will do something extra code in the company class
		
		//now the prodicer and conumer will be highly sync even though how much time it takes to get the produces/ consumed thing it is fine but it works in sync manner 
		
		
	}

}
