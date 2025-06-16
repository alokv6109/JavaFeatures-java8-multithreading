package nestedJavaClassesPractise.anonymousInnerClass;

public class TestAnonymousClass {
    public static void main(String[] args) {
        InterfaceOwn interfaceOwn = new InterfaceOwn() {
            //anonymous class
            @Override
            public void applyBreak() {
                System.out.println("llllllll");
            }
        };
        interfaceOwn.applyBreak();
    }
}
