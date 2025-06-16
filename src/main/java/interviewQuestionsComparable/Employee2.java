package interviewQuestionsComparable;

public class Employee2 {
    private String name;
    private int pjoneNumber;
    private String designation;
    
    public Employee2(String name, int pjoneNumber, String designation) {
        this.name = name;
        this.pjoneNumber = pjoneNumber;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee2{" +
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
