package lambdaExpression;

import interfaces.MyInterface;
import interfaces.StringInterface;
import interfaces.SumInterface;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("My system starts....");
        //Method 1 to implement interface
        MyInterface myInterface = new MyInterfaceImplClass();
        myInterface.sayHello();

        //using anonymos class, gove implenmenmtaion woth the methods roght away give as many as syou would likje
        MyInterface myInterfacey = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("hello from my side from anonymous class");
            }
        };
        myInterfacey.sayHello();
//
        MyInterface obj2 =new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("hel from the world");
            }
        };

        obj2.sayHello();

        //using inteface woth the help of lambda
        MyInterface myInterfacex=  ()-> {
            System.out.println("this is first time i am using labda");
            System.out.println("lalalala llalala");
        };

        myInterfacex.sayHello();
        System.out.println(myInterfacex.getClass().getName());

        MyInterface myInterface1 = ()-> System.out.println("llaallalallalaalla");
        System.out.println("other class name is " + myInterface1.getClass().getName());
        myInterface1.sayHello();

        SumInterface sumInterface = (a, b)->{
            System.out.println("trin trin");
            return a+b;};

        System.out.println(sumInterface.sum(3, 5));
        System.out.println(sumInterface.sum(34, 78765));

        SumInterface sumInterface1 = (a, b)->  a+b; //removed return , braces, int from both args

        System.out.println(sumInterface1.sum(2132, 4564665));

        StringInterface stringInterface = (str) -> str.length();

        System.out.println(stringInterface.length("dsbfdshfdsjfs dsfdsvfdsf dsfsfsdfs"));



    }
}
