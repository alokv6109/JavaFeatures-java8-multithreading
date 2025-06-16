package streamApiDemo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SreamMethodsImportant {
    public static void main(String[] args) {
        String arr[] = {"alok", "aniket", "tashi", "vaish"};
        List<String> list1 =  new ArrayList<>(Arrays.asList(arr));
        System.out.println(list1);


        //1) filter(Predicate: boolena valued func) means whenevr the value is true then the filtering is done
        //using the lamda fiunction you can do the predicate thing
        List<String> namesStartingWithA =  list1.stream().filter( (e)-> e.startsWith("a")).collect(Collectors.toList());
        namesStartingWithA.forEach(e->{   //e is the element that needs to be printed which is in the names... list,
            // baiscally element by elememnt, this is callled consumer
            System.out.println(e);
        });

        System.out.println("-----------------------------------------------------------------------------");

        //2) map(function) //each element pe operation perform kar sakte hai
        // ech elemnt ko leke element return karta hai ,
        //function can be anyting
        Integer arr1[] = {2, 433,344,5,44,65,67, 67,6};
        List<Integer> list2 =  new ArrayList<>(Arrays.asList(arr1));
        System.out.println(list2);

        list2.stream().map((e)->{ //here the e is again an elemnt from the list and the map will return this e only
            return e*e;
        }).collect(Collectors.toList()).forEach(e->{
            System.out.println(e);
        });

        //if you want the map to be taking a method from somewhere else then
        list2.stream().map((e)-> MethodForStream1.squareValue(e)).collect(Collectors.toList())
                .forEach(e-> System.out.println(e));
        System.out.println("-----------------------------------------------------------------------------");


        //3) collect method : stream that you're getting it collects it as ;list, or map or set etc
        //sorted
        list2.stream().sorted().forEach(e->
                System.out.println(e));


        System.out.println("-----------------------------------------------------------------------------");

        //4) minimum method
        System.out.println("minimum in the whole aray is " +list2.stream().min((x,y)-> x.compareTo(y)).get());
        //why using get() because it returns optional object and hence important to use the get  method
        System.out.println("-------------------------------------------------------------");

        List<Integer> integers = Arrays.asList(1, 2,4,12,5555,3,477,33,78,76,32,45,67,78,765,234,1233, 43, 677, 32);
        List<Integer> collectList = integers.stream()
                .filter(x -> x % 2 == 0)
                .peek(e -> System.out.println(e))
                .map(x -> x / 2)
                .distinct()
                .sorted((a, b) -> b - a)
                .limit(4)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(collectList);

        /*

        1. Question: Process a list of numbers
            Given a list of integers, write a Java program that:

            Filters out even numbers.

            Maps the remaining numbers to their squares.

            Sorts the squared numbers in descending order.

            Finds the maximum squared value using reduce().

            Prints the sorted squared numbers and the maximum value.
         */


        Integer integer = integers.stream()
                .filter(a -> a % 2 == 0)
                .map(a -> a * a)
                .sorted((a, b) -> b - a)
                .peek(a-> System.out.println("sorted number i dessc " + a))
                .reduce(0, (a, b)->a>b ? a: b);
        System.out.println(integer);

        /*

        2. Question: Employee Data Aggregation
            Given a list of Employee objects, write a Java program that:

            Filters employees with a salary greater than 40,000.

            Groups these employees by their department using Collectors.groupingBy().

            Counts the number of employees in each department using Collectors.counting().

            Prints the grouped result.

            Expected Method Usage:

            Intermediate Operations: filter()

            Terminal Operations: collect() with Collectors.groupingBy() and Collectors.counting()
         */

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(2, "alok", 4000000.0));
        employees.add(new Employee(2, "aniket", 32323444));
        employees.add(new Employee(4, "ankit", 233323));
        employees.add(new Employee(4, "amit", 3443545));
        employees.add(new Employee(5, "abhay", 54354343));
        Map<Integer, Long> collect = employees.stream().filter(e -> e.getSalary() > 40000.0)
                .collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.counting()));


//        Map<Integer, List<Employee>> collect = employees.stream().filter(e -> e.getSalary() > 40000.0)
//        .collect(Collectors.groupingBy(e -> e.getDeptId()));
        collect.forEach((k, v)-> System.out.println("the grouped data " + k + " : "  + v));

        int[]  nums = new int[]{5, 4,4, 0, 1};
//        List<Integer> integerList = nums.;
//        Map<Integer, Long> collect3 = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.groupingBy(e -> e, (Integer)Collectors.counting()));
//        Map<Long, List<Integer>> collect4 = collect3.entrySet().stream()
//                .collect(Collectors.groupingBy(e -> e.getValue(), Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
//        Map<Department, List<Employee>> byDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));


        /*

        3. Question: String Processing
            Given a list of strings, write a Java program that:

            Removes null or empty strings.

            Converts all remaining strings to uppercase.

            Collects the unique strings into a Set<String>.

            Joins these strings with a comma separator.

            Expected Method Usage:

            Intermediate Operations: filter(), map(), distinct()

            Terminal Operations: collect(), joining() (via Collectors)
         */


        String strings[] = {"alok", "aniket", "tashi", "vaish", null, "greEns", ""};

        String collect1 = Arrays.stream(strings).filter(e -> {
            if(e == null) return false;
            if(e.isEmpty()) return false;
            return true;
        }).map(e -> e.toUpperCase()).distinct().collect(Collectors.joining(" , "));
        System.out.println(collect1);

        /*
        4. Question: Transaction Analysis
            Given a list of Transaction objects, write a Java program that:

            Filters transactions that occurred in 2023.

            Maps these transactions to their amounts.

            Finds the sum of all amounts using reduce() and prints it.

            Creates a list of amounts greater than 1000 and sorts it.

            Expected Method Usage:

            Intermediate Operations: filter(), map(), sorted()

            Terminal Operations: reduce(), collect()

         */

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, LocalDate.of(2023, 2, 23), 346753));
        transactions.add(new Transaction(1, LocalDate.of(2023, 2, 2), 3353));
        transactions.add(new Transaction(1, LocalDate.of(2023, 2, 3), 345453));
        transactions.add(new Transaction(1, LocalDate.of(2024, 2, 23), 454353));
        transactions.add(new Transaction(1, LocalDate.of(2025, 2, 23), 4553));

        Double reduce =
                transactions.stream()
                .filter(e -> e.getDateOfTransaction().getYear() == 2023)
                .filter(e -> e.getAmount() > 1000)
                .sorted((a, b) -> (int) (a.getAmount() - b.getAmount()))
                .peek(e -> System.out.println("the amount in tx is " + e.getAmount())).map(e -> e.getAmount())
                .reduce((double) 0, (a, b) -> a + b);
        System.out.println(reduce);


        /*
        5. Question: Working with Optional and Streams
            Given a list of integers, write a Java program that:

            Filters numbers greater than 50.

            Finds the first number in the filtered list using findFirst().

            If the result is present, multiplies it by 2 and prints the result.

            If not, prints a message stating that no number was found.

            Expected Method Usage:

            Intermediate Operations: filter()

            Terminal Operations: findFirst(), ifPresentOrElse()
         */



        integers.stream().filter(e -> e > 50000).findFirst()
                .ifPresentOrElse(e -> System.out.println(2*e), ()-> System.out.println("no number was found"));

        /*

        6. Question: Aggregate Metrics
            Given a list of Product objects with properties price and category, write a Java program that:

            Filters products in the "Electronics" category.

            Maps them to their prices.

            Calculates the average price using Collectors.averagingDouble().

            Prints the list of prices and the average price.

            Expected Method Usage:

            Intermediate Operations: filter(), map()

            Terminal Operations: collect() with Collectors.toList() and Collectors.averagingDouble()
         */

        System.out.println("6. Question: Aggregate Metrics-----------------");
        List<Product> products = new ArrayList<>();
        products.add(new Product("a", 4566));
        products.add(new Product("bh", 466));
        products.add(new Product("bh", 566));
        products.add(new Product("akk", 40566));
        products.add(new Product("akk", 45966));
        boolean akk = products.add(new Product("akk", 4566));



        double averagePrice = products.stream().filter(e -> e.getCategory().equals("akk"))
                .map(e -> e.getAmount()).peek(e -> System.out.println("the price is " + e))
                .collect(Collectors.averagingDouble(e -> e));
        System.out.println(averagePrice);
//            products.parallelStream()

        /*

        7. Question: Character Processing
            Given a string, write a Java program that:

            Splits the string into a stream of characters.

            Filters out vowels.

            Converts the characters to uppercase.

            Collects them into a single string.

            Expected Method Usage:

            Intermediate Operations: filter(), map()

            Terminal Operations: collect() with Collectors.joining()
         */

        String string = "sdfsfdcvgccAATTuuhjcdhghcgxxcc  kjjhgvhjghjghjg";
        String collect2 = string.chars()
                .peek(e -> System.out.println("charsb code " +e))
                .mapToObj(e -> (char) e)
//                .peek(e -> System.out.println("the car is " + e))
                .filter(e -> !"aeiouAEIOU".contains(String.valueOf(e)))
                .map(Character::toUpperCase) // yha tk ye chars ki stram hai
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(""));
        System.out.println(collect2);

        /*
        int nums = 0;
        int letters = 0;
        int spaces = 0;
        int others = 0;

        Map<String, Integer> map = new HashMap<>();
        // write your code here

         */

//        String s = "a1 b2 c3";
//        s.chars().mapToObj(e -> (char) e)
//                .collect(Collectors.toMap())

        /*

        8. Question: Nested Lists
Given a list of lists of integers, write a Java program that:

Flattens the nested lists into a single stream using flatMap().

Filters out numbers less than 10.

Collects the numbers into a Set<Integer> and prints them.

Expected Method Usage:

Intermediate Operations: flatMap(), filter()

Terminal Operations: collect()
         */

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(5, 12, 8),
                Arrays.asList(15, 3, 25),
                Arrays.asList(7, 10)
        );

        // Process the nested lists
        Set<Integer> resultSet = nestedLists.stream() // Create a stream of lists
                .flatMap(List::stream) // Flatten the nested lists into a single stream
                .filter(num -> num >= 10) // Filter out numbers less than 10
                .collect(Collectors.toSet()); // Collect the numbers into a Set

        // Print the result
        System.out.println("Filtered and Flattened Set: " + resultSet);




    }
}

class Product{
    String category;
    double amount;

    public Product(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}


class Transaction{
    int id;
    LocalDate dateOfTransaction;
    double amount;

    public Transaction(int id, LocalDate dateOfTransaction, double amount) {
        this.id = id;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
    }

    public Transaction(int id, LocalDate of) {
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public double getAmount() {
        return amount;
    }
}
class Employee{
    int deptId;
    String name;
    double salary;

    public Employee(){}

    public Employee(int deptId, String name, double salary) {
        this.deptId = deptId;
        this.name = name;
        this.salary = salary;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
class Person extends Employee{

    public Person(){
        super(1, "ad", 434344);
    }
//
//    @Override
//    public double getSalary() {
//        return super.getSalary();
//    }
}
class MethodForStream1{
	public static int squareValue(int a) {
		return a*a;
	}
}
