package BinarySearchJava;

public class Client {
    public static void main(String[] args) {
        InterfaceMine interfaceMine =new ConcrteCasllForOverload();
        interfaceMine.display();
//        interfaceMine.display(65);

        int a = 128;
        byte b = (byte)a;
        System.out.println(b); // -128 coz bytes can represent that

        //promotion from byte to int
        byte var1 = 126;byte var2 = 1;
        int c = var1/var2; // as soon as you perform operation with bytes  an promotion happend (byte / shrt - > int)

        // but if yuo only need byte then in that case the explicit type casting will have to work
        a = 34;
        double doublevar = 20;

        double v = a + doublevar; // here yet again an promotio happened to bigges data type
        Double aDouble = 234.00;
        double n = aDouble;
        System.out.println(n);


    }
}
