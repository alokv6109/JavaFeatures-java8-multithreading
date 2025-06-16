package interviewQuestionsComparable;

import java.util.Comparator;

public class PhoneNumberComparator implements Comparator<Employee2> {

    @Override
    public int compare(Employee2 o1, Employee2 o2) {
        return o1.getPjoneNumber()  - o2.getPjoneNumber();
    }
}
