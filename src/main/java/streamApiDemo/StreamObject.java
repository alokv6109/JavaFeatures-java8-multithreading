package streamApiDemo;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {
        //Stream API : collection ko processs
        //not only Collection and group of object as well , evem the arrays
        //even the array has it

//        Arrays.stream()
        //1 way to get the strea object
        Stream<Object> emptyStream = Stream.empty(); //empty is static nmathod hence used with the name of the calss
        System.out.println(emptyStream);
        emptyStream.forEach(e -> {
            System.out.println("for thr empty object " + e);
        });

        System.out.println("-----------------------------------------------------------------------------------");
        //2nd way
        //for the arrays : of method satic
        String names[] = {"alok", "aniket", "tashi", "vaish"};
        Stream<String> stringStream = Stream.of(names);
        stringStream.forEach(e ->    //this for each takes the coinsumer ie a lambda value that does'nt returns anything
                System.out.println(e)
        );

        System.out.println("-----------------------------------------------------------------------------------");
        //3rd way
        //builder pattern for usoing the Sream object
        Stream<Object> streamBuilder = Stream.builder().build();

        System.out.println("-----------------------------------------------------------------------------------");
        //4th way
        //using the arrays
        IntStream intStream = Arrays.stream(new int[]{2, 3, 5, 6, 7, 89});
        intStream.sorted().forEach(e ->
                System.out.println(e)
        );

        System.out.println("-----------------------------------------------------------------------------------");
        //5th way 
        //list and set object i collection
        List list = new ArrayList(Arrays.asList(names));
        Stream stream = list.stream();
        stream.forEach(e ->
                System.out.println(e)
        );
        System.out.println("-----------------------------------------------------");


        Stream<Integer> iterate1 = Stream.iterate(0, n -> n + 1).limit(5);
        iterate1.forEach(System.out::println);

        System.out.println("---------------------------------------------------------");

        Stream<Integer> limitStream = Stream.generate(() -> (int) (Math.random() * 100)).limit(5);
        limitStream.forEach(System.out::println);

        System.out.println("--------------------------------------------------------");
//        hasmap and stream
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 1);
        mp.put(2, 3);
        mp.put(3, 3);

        mp.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


    }

}
