package interviewInterfaceDefaultStaticMethods;

import javax.security.auth.Destroyable;

public interface Developer {

	void develop();
	
	void test();
	
	//for java 8 we can make default mathods and static methods-> methods which are called by
	// the class name and are a prop of the class, heap memory
//	default method came in existence so that if some c;lass dot want that
//	methodthey can skip it for them and the contract that all the abstra ct metho
//	need to be overridden will be also not broken with this mehtoid 
//	all the child will be able to use this default method , if child will have more
//	child then that also can use the default method
	
	default void init() {

		System.out.println("the default initilization method is called for all developer......");
	}
	
	default void destroy() {
		System.out.println("the default desctro method is called for all developer of this interface ...");
	}
	
	//the thing is that the default method can be ovverrriden but if you would like that to stop then
	// use the static mehtodds , basically stop the overrrding
	static void method() {
		System.out.println("stataic method in the dev interface ...");
	}
	//there is a general poroperty to the sttic mehtods and that is , that they cant be ovverrien as they are clas property
}
