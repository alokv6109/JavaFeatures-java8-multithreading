package java8PractiseTopics;

public class MethodAndConstructorReferenceExaple {
    public static void main(String[] args) {
        Walkable walkable = ()->{
            System.out.println("i am walking .......");
        };
        ExampleClassA a = new ExampleClassA();
        Walkable walkable1 = a::tupla;
        walkable1.walking();
        walkable.walking();

    }
}

@FunctionalInterface
interface Walkable{
    void walking();
}

class ExampleClassA{
    public void tupla(){
        System.out.println("alllalllallal");
    }
}
