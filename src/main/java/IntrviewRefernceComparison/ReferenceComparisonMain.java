package IntrviewRefernceComparison;

public class ReferenceComparisonMain {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(s1.toString()); 
        System.out.println(s2);
        System.out.println(s1.hashCode()+ "   "+ s2.hashCode());
        System.out.println(s1==s2); //reference comparsion // false
        System.out.println(s1.x == s2.x); //content comparsion explicit

        System.out.println(s1.equals(s2)); //as here the value of x is same and the method is overrriden
        //equals() by default will do the ref comparison , but you can ask t to do ontent comparision by overriding

        //after the equals overriding
        s2.x = 54;
        System.out.println(s1.equals(s2));
    }
}
