package InterviewThreadandMultiThreading.producerConsumer;

public class Producer extends Thread{
	
	Company c;
	
	
	
	public Producer(Company c) {
//		super();
		this.c = c;
	}



	public void run() {
		int i=1;
		while(true) {
			try {
				this.c.produceItem(i);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}

}
