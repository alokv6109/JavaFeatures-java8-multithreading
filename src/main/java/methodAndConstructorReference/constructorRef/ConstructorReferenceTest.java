package methodAndConstructorReference.constructorRef;

public class ConstructorReferenceTest {
    public static void main(String[] args) {
        System.out.println("Learnig constructor interface");

        //lambda implementaion
//        ProviderStudent providerStudent = ()->{
//            return new Student();   //constructo is callled here , default constructor(with no args) basically
//        };
        
        ProviderStudent providerStudent = (id, name)->{
        	return new Student(id, name);
        };

        Student student = providerStudent.getStudent(23, "alok verma");
        student.display();

//		basically we are doing an extra thing of using the things with arguments as well 
        // the basic one is relaly ver imple 
        
        //constructor reference implementation
        //className::new;
        ProviderStudent providerStudent1 = Student::new;
        Student student1 = providerStudent1.getStudent(45, "aniket verma");
        student1.display();
//        providerStudent2

    }
}
