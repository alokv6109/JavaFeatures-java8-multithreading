package interviewQuestionsComparable;

import java.util.Comparator;

public class DesignationComparator implements Comparator<Employee2> {
    @Override
    public int compare(Employee2 o1, Employee2 o2) {
        return o1.getDesignation().compareTo(o2.getDesignation());
    }
    //this comparator is in java.utils
}
