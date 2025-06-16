package InterviewThreadandMultiThreading.producerConsumer;

public class Consumer extends Thread {

	Company c;



	public Consumer(Company c) {
		super();
		this.c = c;
	}
	
	public void run() {
		while(true) {
			try {
				this.c.consumeItem();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
