package methodAndConstructorReference;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Stuff {
    public static void doStuff(){
        System.out.println("I am doing stuff, stuff method");
        System.out.println(LocalDateTime.now().toString());
    }
    
    public static void doStuff(String name){
        System.out.println("I am doing stuff, overloaded stuff method with one argument");
        System.out.println(LocalDateTime.now().toString() + " " +  name);
    }

    public static void threadTask(){
        for (int i=1;i<=10;i++){
            System.out.println(i*2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printNumber(){
        for (int i=1;i<=10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
