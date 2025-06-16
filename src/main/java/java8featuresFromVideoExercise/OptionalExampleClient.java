package java8featuresFromVideoExercise;

import java.util.Optional;

public class OptionalExampleClient {
    public static void main(String[] args) {
        //optional mandates the person using your API || method that he will have to handle for the nullable objects that are return ed
        Optional<String> ans = Optional.of("alok");
        Optional<String> ans2 = Optional.ofNullable(null);
//        System.out.println(ans2.orElseThrow(()-> new RuntimeException()));
        System.out.println(ans2.orElse("null is present"));
        System.out.println(ans.get());
        Optional<Integer> optionalI = Optional.ofNullable(null); //basoicallly ab ye koi exception nhi jaane dega
        optionalI.ifPresent((a)-> System.out.println("the string is " + a));

    }
}
