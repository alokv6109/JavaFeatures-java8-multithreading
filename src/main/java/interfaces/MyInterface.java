package interfaces;

@FunctionalInterface
public interface MyInterface {
    public abstract void sayHello();

    //if one more method is thre then no more a functional interface
    default void hello(){
        System.out.println("hello");
    }


}

//how to use the fucntional interace
/*
1) by creaing new class
2) by creating not new clas but use it here only : anonymous class
3) use lambda expression
4) only ued woth the functional interface

 */