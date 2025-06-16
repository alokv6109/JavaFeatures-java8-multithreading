package java8featuresFromVideoExercise;

import java.util.function.*;

public class BiFunctionalExaple {
    public static void main(String[] args) {
        BiPredicate<String, Integer> stringIntegerBiPredicate=  (str, x) -> str.length() == x;
        boolean test = stringIntegerBiPredicate.test("alok", 5);
        System.out.println(test);
        System.out.println("--------------------------------------");

        BiFunction<String, String, Integer> function = (x,y) -> x.length() + y.length();
        System.out.println(function.apply("alok" , "verma"));

        System.out.println("---------------------------------------------");
        BiConsumer<Integer, Integer> biConsumer = (x, y) ->{
            int z  = x+y;
            System.out.println("alok : " + z);
        };
        biConsumer.accept(4, 65);
        System.out.println("------------------------------------------------");

//        BiSuplier - very intuitive as there cant be no 2 people return ed usually

//        System.out.println("----------------------------------------------------");
//unary ad binary are both basically, functions only
        UnaryOperator<Integer> integerUnaryOperator= (x) -> x*x;
        System.out.println(integerUnaryOperator.apply(3));

        System.out.println("-----------------------------------------------------");
        //<T, R, V> all of them are of same tyoes
        BinaryOperator<String> stringBinaryOperator = (str1, str2) -> str1 +str2;
        System.out.println(stringBinaryOperator.apply("alok ", "verma"));
    }
}
