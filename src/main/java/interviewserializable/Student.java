package interviewserializable;

import java.io.Serializable;

//only those will be serialized wh implement serializable 
//marker interface ie just to knoiw 
public class Student implements Serializable{
	
	/*
	 * transient keyword, if you would like to just skip a property of the class whiule saving in Db , or in file or communiaction gover the netwrok
	 * use the transiet keywork
	 * if file then keywork, if Hibernate then annotatio transient does that job
	 */

	private String name;
	transient private String email;
	
	private int age;
	private String address;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, String email, int age, String address) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void display() {
		System.out.println("Hi my name is : " + this.name);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", age=" + age + ", address=" + address + "]";
	}
	
	
}
