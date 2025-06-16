package java8featuresFromVideoExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FucntionalInterfaceClient {
    public static void main(String[] args) {
        Predicate<Integer> salaryGreaterThan1000 = x -> x>1000;
        String[] strs = new String[]{"al", "adfgfgl", "dgf"};
        Predicate<String> endWithLetterL = x -> x.toLowerCase().charAt(x.length() -1) == 'l';
        Predicate<String> startWithA = x -> x.toLowerCase().charAt(0) == 'a';
        boolean test = endWithLetterL.and(startWithA).test("alokl");
        System.out.println(test);
        System.out.println("printing a predicate object only : " + endWithLetterL.and(startWithA));
        List<String> ans = Arrays.stream(strs).filter(endWithLetterL.and(startWithA)).collect(Collectors.toList());
        System.out.println(ans);
        Predicate<String> containsVipAsPrefix = x-> x.toLowerCase().startsWith("vip");
        System.out.println("------------------------------------------------------");

        //fucntional interfaces - Fucntion<T, R>  = T is the thing you give, single argument and R is the type of return you take
        Function<List<String>, List<String>> studentWithVipAsPrefix = (li) ->{
            List<String> result = new ArrayList<>();
            for(String str : li){
                if(containsVipAsPrefix.test(str)){
                    result.add(str);
                }
            }
            return result;
        };
        List<String> arr = new ArrayList<>();
        arr.add("vip Alok Verma");
        arr.add("vip saksham negi");
        arr.add("amit gupta");
        List<String> res  = studentWithVipAsPrefix.apply(arr);
        System.out.println(res);
        Function<List<String>, List<String>> f3 = (li)-> {
            System.out.println(li);
            return li;
        };
        List<String> applied = studentWithVipAsPrefix.andThen(f3).apply(arr);
        Function<String, Integer> f1= (s)-> s.length();
        Function<Integer, Integer> f2 = (s) -> s*2;

        Integer alok = f1.andThen(f2).apply("alok");
        System.out.println(alok);

        System.out.println("--------------------------------------------------------");
        //consumer interface
        Consumer<String> consumer = (str)-> System.out.println(str);
        consumer.accept("alok verma");
        Consumer<List<Integer>> consumer1 = (li)-> {
            for(int i : li){
                System.out.println(i);
            }
        };
        Consumer<List<Integer>> consumer2 = (li)->{
            for(int i : li){
                System.out.println(i + 100);
            }
        };
        consumer1.andThen(consumer2).accept(Arrays.asList(1,3,5,6));

        System.out.println("-----------------------------------------------------------------");
        Supplier<Integer> supplier = ()-> 3;
        System.out.println(supplier.get());



//        cnsumer.andThen()

    }
}
