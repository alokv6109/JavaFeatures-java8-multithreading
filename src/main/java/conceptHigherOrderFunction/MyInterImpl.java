package conceptHigherOrderFunction;

public class MyInterImpl implements MyInterface{

    int x = 67;
    @Override
    public void dance() {

    }

    public static void main(String[] args) {
        MyInterface myInter = new MyInterImpl();
        System.out.println(myInter.x);
    }
}
