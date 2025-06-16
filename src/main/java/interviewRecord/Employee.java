package interviewRecord;

public record Employee(int id, String name, String email) {
	
	public Employee(String name, String email) {
		this(2, name, email);
	}
	
	public void displayName() {
		System.out.println("th name is : "+ name);
	}
	
	public static void justTest() {
		System.out.println("this is test mathod");
	}

}
