package methodAndConstructorReference.constructorRef;

@FunctionalInterface
public interface ProviderStudent {
//    public Student getStudent();
    public Student getStudent(int id, String name);
}
