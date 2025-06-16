package optionalClassDemo;

import java.util.Optional;

public class OptionalClassDemo {

    private String name;
//setter and getter mei gettter ko optional kar do idhar mei


    public static Optional<String> getName(){
//        String name ="alok verma";
        String name = null;
        return Optional.ofNullable(name);
    }
    public static void main(String[] args) {
        //its like a box, might or might not contain a value and in both case thre is no issue as such
        //important functions isPOreseent to check if there is s/t or not
        //cleans the code as well
        //get() to get that value , so everytime you see a get() method being there means
        // a optional class object is actually applied
        //there and hence get() is used to just get the value
        //since 1.8/ java8
        //get() : if no value is present then noSuchElementexception is generated

        String str= null;
        if (str==null){
            System.out.println("this si a nu;ll object");
        }else{
            System.out.println(str.length());
        }

        String s = "alalalala";
        Optional<String> optional = Optional.ofNullable(s);
        System.out.println("is value present or not with isPresent method : " + optional.isPresent());
        System.out.println("the value e get sig the get() method " + optional.get());
        System.out.println(optional.orElse("No value in this object"));
        optional.ifPresent((a) -> System.out.println(a));
        System.out.println(optional);
        System.out.println("hash code "+ optional.hashCode());

        Optional<String> optionalS =  OptionalClassDemo.getName();
        System.out.println(optionalS.orElse("null is returnned"));
    }
}

