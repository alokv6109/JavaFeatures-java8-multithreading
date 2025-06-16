package methodAndConstructorReference.constructorRef;

public class Student {
	
	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("the id is : "+ id + " and the name is : " + name);
	}

    public void display(){
        System.out.println("i am a student");
    }

    public Student(){
        System.out.println("constructor of the student class");
    }
}
