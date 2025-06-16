package concurrentCollection;

//import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeEaxmple {
	
	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<String>();
//		System.out.println(list);
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
//		System.out.println(list);
		
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
			System.out.println(list);
			
		};
		
		//start thread

		new Thread(thread2).start();
		//har thread ki apni ek expectatio hai wo meet hogi
		// t2 kahega pehle add ho jao , add ho jatega kyuki yhi expectation ahi
		new Thread(thread1).start();
		//t1 kahega ab jo bhi hai tere paas usse read karo, toh sab read hoga

	}

	/*

	| **Collection**               | **Thread-Safe Implementation**           | **Concurrency Technique**             |
| ---------------------------- | ---------------------------------------- | ------------------------------------- |
| `HashMap`                    | `ConcurrentHashMap`                      | Fine-grained locking, CAS             |
| `ArrayList`                  | `CopyOnWriteArrayList`                   | Copy-on-write (no locks for reads)    |
| `LinkedList`                 | `ConcurrentLinkedQueue/Deque`            | Lock-free CAS                         |
| `TreeMap`                    | `ConcurrentSkipListMap`                  | Fine-grained locking in skip lists    |
| `HashSet`                    | `ConcurrentHashMap.newKeySet()`          | Follows `ConcurrentHashMap` mechanism |
| `PriorityQueue`              | `PriorityBlockingQueue`                  | Global lock (`ReentrantLock`)         |
| `Deque`                      | `LinkedBlockingDeque`                    | Dual lock (`ReentrantLock`)           |
| `Vector`, `SynchronizedList` | `Vector`, `Collections.synchronizedList` | `synchronized` methods                |

	 */


}
