package methodAndConstructorReference.exampleStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        Integer arr[] = {2, 433,344,5,44,65,67, 67,6};
        List<Integer> list1 =  new ArrayList<>(Arrays.asList(arr));
        System.out.println(list1);

        //lambda implemntaion for the for each method
        list1.stream().forEach(e -> System.out.println(e));
//                e->{
//            System.out.println(e);
//        }




        System.out.println("----------------------------------------------------------");

        //suing the method reference to do the work
        list1.stream().forEach(System.out::println);
        //here the ststem is class, out is a static variable here that gives the PrintStream Class, and println is void method
        //method reference is a alternative to lambda expression

    }
}
