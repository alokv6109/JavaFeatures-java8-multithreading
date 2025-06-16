package interviewRecord;

public class MainClient {
	
	public static void main(String[] args) {
		
		
		/*Recoirds are final ie no subclass of this can be made and extended
		 * we can use multiple constructor in the record - make it on your own
		 * can make all kind of extra static or instance mehtods
		 * record object are immutable ie once created cannot be chanmged, ie no setter is given to you 
		 * apne rukes hai , pehle pojos hote the jisme boiler plate code likhne padte the jaise k getter setter etc wali cheeze iusme 
		 * wo sab nhi krna padta , so saves a lot of time biut has its own rules to deal with 
		 */
		
//		Employee person = new Employee(1, "alok", "alokv@gmail.com");
		
		Employee person2 = new Employee("aniket", "anikv@fdfs.cdss");
		
//		System.out.println(person2.displayName());
		person2.displayName();
		Employee.justTest();
		
		System.out.println(person2.toString());
	}

}
