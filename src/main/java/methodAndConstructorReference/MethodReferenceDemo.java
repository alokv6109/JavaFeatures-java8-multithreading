package methodAndConstructorReference;

public class MethodReferenceDemo {
    public static void main(String[] args) {

        //usual method to do this work
        //provode the impl of the work interface: suing lambda
        WorkInterface workInterface = (a)->{
            System.out.println("this is do task new method implementation using lambda");
            System.out.println("the name is : " + a);
        };
        workInterface.doNewTask("alok verma");

        //now we want the doStuff method to give the implemenataion to this method as we
        // think that they are same and hence the
        //method referewnce comes in play
        //basically that method is referred , its complete body is now filled in that method
        WorkInterface workInterface1 = Stuff::doStuff;   //static method is refereed
        workInterface1.doNewTask("a string");
//        workInterface1.doTask();
        //the i,mportant thing her is that you're providing the body/implementaion of
        // the doWork method in the iterface so the args
        //and the return type of the other method have to e same
        // so void doStuff(null)  ==== void doTask(null)

        Runnable runnable = Stuff::threadTask; //the same implementaion is used for the
        // runnable functional interface, method interface
        Thread thread = new Thread(runnable);
        thread.start();

        //instance method
        //first creating the object - basically a mehtod ie there and called only after creating an object
        Stuff stuff = new Stuff();
        Runnable runnable1 = stuff::printNumber; //referring non static method
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        //constructor reference



    }
}
