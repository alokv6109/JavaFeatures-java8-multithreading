package nestedJavaClassesPractise;

public class LocalInnerClass {

    ///thi is actually an exaple of the memebr inner class coz the inner class is like the member variable of the class.
    int instanceVariable = 10;
    static int staticVariable = 20;

    class NestInnerClass{
        public void display(){
            System.out.println("nester inner class " + staticVariable + instanceVariable);
        }
    }
}
