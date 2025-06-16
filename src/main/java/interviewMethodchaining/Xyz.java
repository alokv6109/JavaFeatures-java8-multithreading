package interviewMethodchaining;

public class Xyz {

	int x;
	
	public Xyz setX(int x) {
		this.x = x;
		
		return this;
	}
	
	public Student display() {
		System.out.println("hello from xyz class");
		return Student.of().setCity("chandigarh");
	}
}
