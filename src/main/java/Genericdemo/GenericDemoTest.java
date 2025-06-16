package Genericdemo;

import java.util.ArrayList;
import java.util.List;

public class GenericDemoTest {
    public static void main(String[] args) {
        // <> angualr brackets is for the gerenics
        //specified already that it will only contain string
        //type safety is provided: compile time ie the developer will get to know about this
        //this is generic: ie generic for the String
        List<String> list = new ArrayList<>();
        list.add("alok verma");
        System.out.println(list);
//        list.add(1); //will get error

        //this is non generic
        //does not geuarentee typesafety
        List list1 = new ArrayList();
        list1.add("alok verma");
        list1.add(343);
        list1.add(321.333);
        System.out.println(list1);


    }
}
