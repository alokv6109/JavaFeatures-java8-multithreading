package smallTopics;

public class VarargsAdvancedPractise {
    public static void main(String[] args) {
        printAll("apple", "banana", "cherry");
        printAll(1, 2, 3, 4, 5);
        log("INFO", "Server started", "Listening on port 8080");
        print("Hello");                // Calls the single version
        print("Hello", "World");       // Calls the varargs version
        String alok = String.format("alla %s", "alok");
        System.out.println(alok);


    }

    public static void print(String msg) {
        System.out.println("Single: " + msg);
    }

    public static void print(String... msgs) {
        System.out.println("Multiple:");
        for (String s : msgs) {
            System.out.println(" - " + s);
        }
    }


    public static void log(String level, String... messages) {
        for (String msg : messages) {
            System.out.println("[" + level + "] " + msg);
        }
    }


    @SafeVarargs
    public static <T> void printAll(T... elements) {
        for (T elem : elements) {
            System.out.println(elem);
        }
    }

}
