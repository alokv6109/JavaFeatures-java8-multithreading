package Genericdemo;

public class Box {
    //genric class
    //object class is always the oarenbt class of all classes and hence it can refer the child object
    Object container;

    public Object getContainer() {
        return container;
    }

    public Box(Object container) {
        this.container = container;
    }
}
