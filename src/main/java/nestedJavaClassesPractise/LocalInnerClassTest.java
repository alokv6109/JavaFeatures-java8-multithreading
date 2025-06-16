package nestedJavaClassesPractise;

public class LocalInnerClassTest {
    public static void main(String[] args) {

        LocalInnerClass localInnerClass = new LocalInnerClass();
        LocalInnerClass.NestInnerClass nestInnerClassObj = localInnerClass.new NestInnerClass();
        nestInnerClassObj.display();
    }

}
