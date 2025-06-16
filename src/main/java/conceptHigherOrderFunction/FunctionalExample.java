package conceptHigherOrderFunction;

public class FunctionalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sarkar sarkar = new Sarkar();
//		sarkar.workForMe();
		Runnable runnable  = sarkar.workForMe(()->{
			System.out.println("I am lambda function and i'm passed in the method ");
		});
		
		runnable.run();
		
		MyInterface danceable = ()->{
			System.out.println("Would you please dance for me !!!");
		};
		
		sarkar.danceforMe(danceable); //value is passed 
//		an dthe type is passed as ars int a = 10;
//		can be also done as 
		sarkar.danceforMe(()->{
			System.out.println("Would you please dance for me bugghdi!!!");
		});
		
		//by anonymous class 
		sarkar.danceforMe(
				new MyInterface() {
					@Override
					public void dance() {
						// TODO Auto-generated method stub
						System.out.println("yoo bebes dance for me !!!");
						
					}
				}
				);
		
	}

}
