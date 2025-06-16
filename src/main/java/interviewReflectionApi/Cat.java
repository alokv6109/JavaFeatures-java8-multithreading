package interviewReflectionApi;

public class Cat {
	
	private String name;
	private int age;

	public Cat(String name, int age) {
//		super();
		this.name = name;
		this.age  =age;
	}
//	private int age;

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	} blocked for a purpose to show how to set a name whn ou dont have a direct method to do so 
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void meow() {
		System.out.println("Meow");
	}
	
	private void heyPrivate() {
		System.out.println("private mathod");
	}
	
	public static void publicStatic() {
		System.out.println("pulbic static mehtod");
	}
	
	private static void privateStatic() {
		System.out.println("private static method");
	}
//	static class lala{
//
//	}

}
