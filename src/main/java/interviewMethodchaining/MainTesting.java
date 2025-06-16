package interviewMethodchaining;


public class MainTesting {
    public static void main(String[] args) {
        // TODO: 3/12/2023 for doing the method chaining
//        Student st = new Student();
////        st.setAge(26);
////        st.setCity("mohali");
////        st.setName("Alok verma");
//
//        // TODO: 3/12/2023 done using the this returning ie same Student is returned by the setter
//         methods, subtle change to be noticed
//        // but it doies the work
//        st.setName("Alok verma").setAge(50).setCity("Mohali");

        // TODO: 3/12/2023 using the builder patterns
        Student st  =Student.of().setCity("mohali").setName("alok verma").setAge(40);

//        Student student= Student.of().setCity("mohali");
        System.out.println(st.toString());
    }
}
