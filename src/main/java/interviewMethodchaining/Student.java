package interviewMethodchaining;

public class Student {
    private String name;
    private int age;
    private String city;

    private Student(){  // TODO: 3/12/2023 this is done so that you can't use the new Student() kindaa thing and hence you'll
        // use spomething else to return the student

    }

    public static Student of(){ // TODO: 3/12/2023 off method is used to basicaly remove the coinstructior thing and use this method to do the work 
        return new Student();
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public Student setCity(String city) {
        this.city = city;
        return  this;
    }
}
