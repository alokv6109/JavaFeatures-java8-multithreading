package interviewInterfaceDefaultStaticMethods;

public class IosDeveloper implements Developer{

	@Override
	public void develop() {
		// TODO Auto-generated method stub
		System.out.println("I am an IOS devloper");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("I am IOS tester also-  iosdev class");
	}
	
	//if you would liek to give the own impl of this method ie init() default method then you an 
	@Override
	public void init() {
		System.out.println("in the ios init");
		Developer.super.init();
	}

	public static void method() {
		System.out.println("in ios staic method ");
	}
}
