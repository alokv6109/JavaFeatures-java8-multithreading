package interviewWrapper;

public class DummyWrapper {
	
	private int i;
	
	public DummyWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public DummyWrapper(int i) {
		this.i =i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return Integer.toString(i);
	}
	
	public static void main(String[] args) {
		DummyWrapper wrapper= new DummyWrapper(32);
		System.out.println(wrapper.toString());
		
		int i = 13;
		DummyWrapper dummyWrapper  = new DummyWrapper(i);
		System.out.println(dummyWrapper);
		int k  = dummyWrapper.getI();
		System.out.println(k); //for the unboxing of the primitive value this get wont be there
		System.out.println("-----------------------------------------------");
		Integer integer = 55;
		System.out.println(integer.hashCode());
		integer = 77;
		System.out.println(integer.hashCode());
		printData(integer);
		System.out.println(integer);
		System.out.println("-------------------");
		String name= "alok";
		printInfo(name);
		System.out.println(name);
		System.out.println("-------------------------------");
		int[] arr = new int[10];
		arr[0]= 1;
		arr[1] = 2;
		arr[2] = 3;
		printAray(arr);
		System.out.println(arr[2]);
		System.out.println("------------------------");
		String kaka = "kaak";
		String kaka2 = kaka.toUpperCase();
		System.out.println(kaka.hashCode());
		System.out.println(kaka2.hashCode());

	}

	private static void printAray(int[] arr) {
		System.out.println("before changinf " + arr[2]);
		int[] arr2 =arr;
		arr[2] = 5;
		System.out.println("after changign " + arr2[2]);
	}

	private static void printInfo(String name) {
		System.out.println("before changing " + name);
		String string = name;
		name ="aniket";
		System.out.println("after changing " + string);
	}

	private static void printData(Integer integer) {
		System.out.println("before changing " + integer);
		Integer integer1 = integer;
		integer = 67;
		System.out.println("after changing " + integer1);
		return ;
	}


}
