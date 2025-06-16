package interviewHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
//        Map<Integer, String> mp = new TreeMap<>();

//        map.put("Ankit", 20);
//        map.put("Uttam", 25);
//        map.put("anil", 32);
//        map.put("rashmi", 89);
//        map.put(null, 567);
//        System.out.println(map);
//
//        for(String key: map.keySet()){
//            System.out.println(key);
//        }
//        BiConsumer

        Map<Pair, Integer> mp = new HashMap<>();
        Pair p = new Pair(1, "alok");
        Pair p2 = new Pair(1, "alok");
        Pair p3 = new Pair(1, "alok");

        System.out.println(p.hashCode() + p.toString());
        System.out.println(p2.hashCode() + p2.toString());
        mp.put(p3, 32);
        mp.put(p2, 3);
        mp.put(p, 39);
//
        System.out.println(mp);

    }

    static class Pair{
        private  int id;
        private String name;

        public Pair(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof Pair)) return false;
            if((o instanceof Pair) && this.id == ((Pair) o).id && this.name.equals(((Pair) o).name)) return true;
            return false;
//            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
//            return 123;
        }
    }
}
