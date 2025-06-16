package nestedJavaClassesPractise;

public class LocalParentOuterClass {
    //this is actually the local inner class

//    if in for , if , method , while loop
//    only defaut access modifier s used for the access of the object - coz oncce the closed bracket of the block is encountered
//    the whole block disapperas from the stack view
    int instanceVariable = 10;
    static int staticVariable1 = 20;

    public void display(){
        int methodVariable = 30;
        class LocalInnerClass{
            int instanceVariable = 11;
            static int staticVariable = 22;
            public void print(){
//                sab kuch access ho sakta hai

                System.out.println("lalal " + instanceVariable + staticVariable + methodVariable + LocalParentOuterClass.staticVariable1 + LocalParentOuterClass.this.instanceVariable );
            }
        }

        //and now to create the object and use it all of that is dione inside the block only
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.print();
    }


}
