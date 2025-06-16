package interviewInterfaceDefaultStaticMethods;

public class ClientMain {
	
	/*
	 * interface means all the methods that are there will be signed toa contract that the implementaion class will
	 * give the body of this method 
	 * 
	 */
	
	public static void main(String[] args) {
		Developer developer = new WebDeveloper();
		Developer iosDeveloper =  new IosDeveloper();
		
		developer.develop();
		developer.init();
		iosDeveloper.init();
		IosDeveloper.method();
		Developer.method();
	}

}
