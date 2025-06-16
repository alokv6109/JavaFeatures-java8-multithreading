package interviewQuestionsComparable;

//import org.jetbrains.annotations.NotNull;

public class Employee implements Comparable<Employee>{
    private String name;
    private int pjoneNumber;
    private String designation;

    @Override
    public int compareTo( Employee o) {
        System.out.println("the diff between "+ this.pjoneNumber + " and " + o.pjoneNumber + " is " + (this.pjoneNumber - o.pjoneNumber));
        return this.pjoneNumber - o.pjoneNumber; //what is + will be bigger and else the other will be smaller and if same then 0 would be returned
    }

    public Employee(String name, int pjoneNumber, String designation) {
        this.name = name;
        this.pjoneNumber = pjoneNumber;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", pjoneNumber=" + pjoneNumber +
                ", designation='" + designation + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPjoneNumber() {
        return pjoneNumber;
    }

    public void setPjoneNumber(int pjoneNumber) {
        this.pjoneNumber = pjoneNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
