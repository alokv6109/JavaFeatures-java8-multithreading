package conceptHigherOrderFunction;

public class Sarkar {
	
//	public void workForMe() {
//		System.out.println("Yes, boss I'm working for you...!!");
//	}

//	while working woth the lambda functions 
	
//	public void workForMe(Runnable runnable) {
//		runnable.run();
//		System.out.println("Yes, boss I'm working for you...!!");
//	}
	
	public Runnable workForMe(Runnable runnable) {
		runnable.run();
		System.out.println("Yes, boss I'm working for you...!!");
		return runnable;
	}
	
//	now here the thing is runnable is a functional interface already there and hence its fine to use this when it comes to using the other function 
//	it gets a little bit tricky
	
	public void danceforMe(MyInterface danceable) {
		danceable.dance();
	}
}
