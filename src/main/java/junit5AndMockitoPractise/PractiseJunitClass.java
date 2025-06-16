package junit5AndMockitoPractise;

public class PractiseJunitClass {

    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int res =  trumbaktu();
        System.out.println("res from tumbaktu is " + res );
        return numerator / denominator;
    }

    private int trumbaktu()
    {
        System.out.println("tere naam !!!");
        return 1;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String sanitized = input.replaceAll("\\s+", "").toLowerCase();
        return sanitized.equals(new StringBuilder(sanitized).reverse().toString());
    }

    public static String getGreeting(String name) {
        return  name + "!";
    }


    public static void log(String message) {
        System.out.println(message);
    }



}
