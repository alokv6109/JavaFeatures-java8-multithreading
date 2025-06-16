package IntrviewRefernceComparison;

public class Student {
	int x=  34;
    //override the equals method to override the reference cpomparison
	
	
    @Override
    public boolean equals(Object obj){
        Student st = (Student) obj;  //type cast the Object var to the Student type class
        return st.x == this.x; //the comarison woth the val of x
    }
}
