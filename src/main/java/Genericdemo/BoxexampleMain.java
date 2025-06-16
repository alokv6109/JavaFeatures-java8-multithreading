package Genericdemo;

public class BoxexampleMain {
    public static void main(String[] args) {
        Box box = new Box("water");
        Box box1 = new Box(4);
        Box box2 = new Box(4343.3221);
        //this type of class is not a very good method becaus the Object class can get anything in there and hence run time error can be
        //expected which is not a very good practice

        //but generic or geeneral will help in the declaration of what needs to be given
        //Generic will provide type safety
        //now playingwoth the safebox class
        SafeBox<String> safeBox = new SafeBox<>();
        safeBox.container = "sadsadsad";
//        safeBox.container = 342;
        
        System.out.println(safeBox.getContainer());
        System.out.println(safeBox.container.getClass().getName()); //class nikal liya taakin check kar sakeki kaun se type ki value hai 
        
        String s1 ="alok";
        String s2 ="alok";
        
        if(s1.equals(s2)) {
        	System.out.println(s1+ " " + s2+ " true");
        }else {
        	System.out.println(s1+ " " + s2+  " false");
        }
        
        safeBox.performTask();
    }
}
