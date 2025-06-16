package java8featuresFromVideoExercise;

import java.io.Serializable;
import java.util.Comparator;

@FunctionalInterface
interface Predicate<T> extends Cloneable, Serializable, Comparator<T> {
    int hashCode();
    String toString();
    boolean equals(Object o);
    int compare(T o1, T o2);
    static void registerNatives() {        }
    private void detect() {
    }
    default void analyze() {        }
}
