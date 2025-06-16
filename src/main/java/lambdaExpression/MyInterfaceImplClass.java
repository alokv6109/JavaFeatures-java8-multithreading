package lambdaExpression;

import interfaces.MyInterface;

public class MyInterfaceImplClass implements MyInterface {
    @Override
    public void sayHello() {
        System.out.println("I am saying hello from MyIntercaeImpl ");
    }
}

//biut the thinmg with this is that if there happen to be 100 impl of this method then 100 classes will be made and the mehtpdwill ne
//implemnted
