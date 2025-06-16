package interviewQuestionsComparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortExample {
    //for the cmaprable and comparator thing
    public static void main(String[] args) {
//        ArrayList<Integer> marks = new ArrayList<>();
//        marks.add(12);
//        marks.add(34);
//        marks.add(435);
//        Collections.sort(marks);
//        System.out.println(marks);

        List<Employee> employeeList = new ArrayList<>();
        System.out.println(employeeList.hashCode());
        employeeList.add(new Employee("durgesh", 213233122, "manager"));
        employeeList.add(new Employee("alok", 21322324, "SDE2"));
        employeeList.add(new Employee("aniket", 323312243, "SDE1"));
        System.out.println("Before sorting  "+ employeeList);
        Collections.sort(employeeList);   //here the reason is that the it will not know on whjat basis to sort
        //implement comparable, its an interface and hence your class will have to implement its mehtod
        //single sorting logic k liye compareable use kiya hai

//        Collections.sort(employeeList);
        System.out.println("after sorting "+ employeeList);
        
        System.out.println("-------------------------------------------------------------------");

        //for multiple soting logics we use the comparator fucntion
        //we make different class altigether
        List<Employee2> employeeList1 = new ArrayList<>();
        
        employeeList1.add(new Employee2("durgesh", 213233122, "manager"));
        employeeList1.add(new Employee2("alok", 21322324, "SDE2"));
        employeeList1.add(new Employee2("aniket", 323312243, "SDE1"));
        
        System.out.println("Before sorting  "+ employeeList1);
        Collections.sort(employeeList1, new DesignationComparator());
        
        System.out.println("Designatin conparator "+ employeeList1);
        

        System.out.println("-------------------------------------------------------------------");
        
        List<Employee2> employee2s = new ArrayList<>(employeeList1);
        
//        Collections.sort(employee2s, new PhoneNumberComparator());
        Collections.sort(employee2s, (x, y)-> x.getPjoneNumber() - y.getPjoneNumber());
        Collections.reverse(employee2s);
        int[] arr  =new int[]{1,2,3,4,5};
        
        System.out.println("phone number comparator "+ employee2s);
        
        System.out.println("-------------------------------------------------------------------");
        
        Collections.sort(employee2s,
//                (a, b)->{a.getName().equals(b.getName())}
                new NameComparator()
        );
        System.out.println("the name comparator is : " + employee2s);
        System.out.println(employee2s.hashCode());

    }
}
