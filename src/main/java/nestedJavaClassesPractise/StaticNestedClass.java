package nestedJavaClassesPractise;

public class StaticNestedClass {
    int instanceVariable = 10;
    static int staticVariable = 20;

    static class NestedClass{
        public void print(){
            System.out.println("oinside nested static class" + staticVariable);
        }
    }

    //priavte access modifier in the nested ckass only
    private static class PrivateNestedClass{
        public void print(){
            System.out.println("oinside nested static class" + staticVariable);
        }
    }

    public static void main(String[] args) {
        StaticNestedClass.PrivateNestedClass privateNestedClassObj = new StaticNestedClass.PrivateNestedClass();
        privateNestedClassObj.print();

    }
}

//private class Pair{
//
//}
