package streamApiDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StremDemo {
    public static void main(String[] args) {
        //create a list for filter all even numbers
        //we are basocally trying to diffrentiatre between strean and non stream: lines of codes difference
        Integer arr[] = {2, 433,344,5,44,65,67, 67,6};
        List<Integer> list1 =  new ArrayList<>(Arrays.asList(arr));
        System.out.println("all the eleemnts in the list are: " + list1);
        //without stream - add all the even numbers
        List<Integer> res = new ArrayList<>();
        for (Integer i:list1){
            if(i%2==0){
                res.add(i);
            }

        }

        System.out.println("the even numbers in the list are " +res);

        //while using stream
        Stream<Integer> stream = list1.stream();
        
//        EvenMethod obj = new EvenMethod();
        
        //the predicate can aloso be goven as the method which return boolean and is in
        // another class EvenMethod class , so that is also a way of doing it
        //but the best is the lambda function
        //boolean valued function is called as predicates ie if it returns true then elements will be filtered out
        List<Integer> res2 = stream.filter(i -> i%2==0).collect(Collectors.toList());
//        List<Integer> res2 = stream.filter(i -> MethodsForStream.getEvenNumbers(i)).collect(Collectors.toList());
// i->i%2==0 is the function
//        and if this returns true then only the
        //element will be taken out and kept in the list if false then not
        
        System.out.println("the result is by stream API : "+ res2);

//        List<Integer> list = list1.stream().filter( (i)->i>50).collect(Collectors.toList());
        List<Integer> list = list1.stream().filter( (i)->MethodsForStream.getNumberGreaterThanFifty(i)).collect
                (Collectors.toList());
        
        System.out.println("no greater than 50 are " + list);

        //Stream object get karne k liye stream() function se hota hai, ye stream function is
        // with the collections that youre working on
        //Stream is interface

    }
    
}
    class MethodsForStream{
	   
	   public static boolean getEvenNumbers(int a) {
		   return a%2==0;
	   }
	   
	   public static boolean getNumberGreaterThanFifty(int a) {
		   return a>50;
	   }
   }

