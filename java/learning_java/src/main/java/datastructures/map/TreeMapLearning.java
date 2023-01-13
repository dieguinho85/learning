package datastructures.map;

import java.util.TreeMap;

public class TreeMapLearning {
    public static void test() {
        TreeMap<Integer, String> m = new TreeMap();

        m.put(4, "D");
        m.put(3, "C");
        m.put(1, "A");
        m.put(2, "B");
        m.put(5, "E");

        m.keySet().stream().forEach(k -> System.out.println(m.get(k)));
    }
}
