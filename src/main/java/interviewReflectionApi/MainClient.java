package interviewReflectionApi;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClient {
	
	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException, IllegalAccessException {
		Cat mycat = new Cat("stalla", 2);
		Field[] catFields =   mycat.getClass().getDeclaredFields();
		
		for(Field f:catFields) {
			System.out.println(f);
			//for setting the name we have 
			if(f.getName().equals("name")) {
				f.setAccessible(true); //or else it will thorw exception : class interviewReflectionApi.MainClient cannot access a member of class interviewReflectionApi.Cat with modifiers "private"
//				at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:385)
				f.set(mycat, "Jimmy");
			}
		}
		
		//now for changing the name of the cat and not changing the source codeas there is no set name method to do so 
//		use the reflection API for this 
		System.out.println(mycat.getName());
		System.out.println("---------------------------------------------------------------");
		
		//for getting all the methods
		Method[] catMethods =  mycat.getClass().getDeclaredMethods();
		for(Method m: catMethods) {
			System.out.println("the name of method : " + m);  //public java.lang.String interviewReflectionApi.Cat.getName() - access_level return_type fullyclassified_MethodName
//			now with methods one coool thing that you can do is execute this method 
			if(m.getName().equals("meow")) {
				m.invoke(mycat); //as there are no args in this method that it needs and hence you need not worry about the invoke method , just call this
			}
			if(m.getName().equals("heyPrivate")) {
				//here again the acccessible needs to be allowed and hence you can allow it 
				m.setAccessible(true);
				m.invoke(mycat);
			}
			//there are some methods which are statc and hence dont need an object to call them
			if(m.getName().equals("publicStatic")) {
				m.invoke(null);
			}
			if(m.getName().equals("privateStatic")) {
				m.setAccessible(true);
				m.invoke(null);
				
			}
		}
		/*
		private java.lang.String interviewReflectionApi.Cat.name
		private int interviewReflectionApi.Cat.age
		Jimmy
		---------------------------------------------------------------
		the name of method : private void interviewReflectionApi.Cat.heyPrivate()
		private mathod
		the name of method : public void interviewReflectionApi.Cat.meow()
		Meow
		the name of method : private static void interviewReflectionApi.Cat.privateStatic()
		private static method
		the name of method : public void interviewReflectionApi.Cat.setAge(int)
		the name of method : public static void interviewReflectionApi.Cat.publicStatic()
		pulbic static mehtod
		the name of method : public int interviewReflectionApi.Cat.getAge()
		the name of method : public java.lang.String interviewReflectionApi.Cat.getName()

Process finished with exit code 0


		 */
		//so while testing also the reflection API needs to be working fine because over there can be a
		// private methid and that might
		// need to be tested if it i functioning the
//		way it is supposed to be working 
//		if you use reflection API non seriously then it might create a lot of bugs as the code is
//		relaly easy to break in usig the reflectoion
//	reflection works because it has to figure out and manipulate all the things at the run time and not
//	the compile time optimizatons and hence code is
//		way slower than usual
//		when to use the reflection the 
//		1. if there is somethi that can be used w/o using the reflection then skip it , more fast, and
//		easy to work with, more robust , because nithing works
//		lets say you change the method name in cat class and dont chane the name in the if statments above
//		your code wont be wokring in the correct way that
//		its supposed to be workng in 
//		reflection is used when there is some legit thing you would like to use it for 
//		lest say things like junit testing etc
		
	}

	
}
