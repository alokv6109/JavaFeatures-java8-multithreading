package InterviewThreadandMultiThreading;

class UserThread extends Thread{
	
	public void run() {
		System.out.println("this is user defined thread");
	}
	
}

public class ThreadOperations {

	public static void main(String[] args) {
		System.out.println("started");
		System.out.println(43+43);
		System.out.println("the name of the current thread : " +Thread.currentThread().getName());
//		Integer i = Thread.currentThread().hashCode();
		Thread x = Thread.currentThread();
		x.setName("Alok's thread");;
		System.out.println(x.getName());
//		System.out.println("ended program");
		
		//get thr user defined thread
		Thread thread = new UserThread();
		thread.start();
	}
}
