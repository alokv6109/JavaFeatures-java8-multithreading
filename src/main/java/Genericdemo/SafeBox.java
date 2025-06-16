 package Genericdemo;

public class SafeBox<T> {

    T container;

    public T getContainer() {
        return container;
    }
//
//    public void setContainer(T container) {
//        this.container = container;
//    }

    public SafeBox(T container) {
        this.container = container;
    }
    public SafeBox(){
        super();
    }
    
    public void performTask() {
    	if(container instanceof String) {
    		System.out.println("length of "+ container + " is " + ((String)this.container).length());
    	}
    	else if(container instanceof Integer) {
    		System.out.println("the value is " + container);
    	}
    }
}
