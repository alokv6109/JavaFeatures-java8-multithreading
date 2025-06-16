package java8PractiseTopics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
//        TODO: stream building
        int[] ans = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(ans);
        intStream.forEach((e)-> System.out.println(e));
        System.out.println("----------------------------");
//        Stream<Integer> boxed = intStream.boxed();
//        boxed.forEach((e)-> System.out.println(e));
//        System.out.println("----------------------------");


        String[] strings = {"alok", "amit"};
        Stream<String> stringStream  = Stream.of(strings);
        stringStream.forEach((e) -> System.out.println(e));
        System.out.println("----------------------------");

        Stream<Object> emptyStream = Stream.empty(); //empty is static nmathod hence used with the name of the calss
        System.out.println(emptyStream);
        emptyStream.forEach(e -> {
            System.out.println("for thr empty object " + e);
        });
        System.out.println("----------------------------");
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 1);
        mp.put(2, 3);
        mp.put(3, 3);

        mp.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        System.out.println("---------------------------------");

        List<Integer> integers = List.of(1,2,3,4,5);
        integers.stream().forEach((e)-> System.out.println(e));

        System.out.println("-----------stream methods--------------");
//        TODO: stream methods
        // ou want to get the values of the hasmap
        Map<Integer, Integer> mp1 = new HashMap<>();
        mp1.put(1, 1);
        mp1.put(2, 3);
        mp1.put(3, 3);
        List<Integer> collect = mp1.entrySet().stream().map(entry -> entry.getValue()).toList();
        collect.stream().forEach(e-> System.out.println(e));

//        TODO:go through various interfactes
    }
}
