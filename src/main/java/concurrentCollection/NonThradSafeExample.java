package concurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NonThradSafeExample {
	//forst see if we dont acheive thread safety
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
//		System.out.println(list.hashCode());
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		list.add("foifth");
		list.add("sakshanm");
		list.add("alok");
		list.add("anil");
		list.add("lalalalal");
		list.add("bigghu");
		System.out.println(list);
		
		
		Runnable thread1 = ()->{
			//code for the thread1
			for(String str: list) {
				System.out.println(str);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable thread2 = ()->{
			//code for threead2 
			//mutation is done here is changes to the object of the list 
			
			list.add("aniket");
			list.add("aniket");
			list.add("aniket");
			
		};
		
		//start thread
		
		new Thread(thread1).start();
		new Thread(thread2).start();
	}

}
