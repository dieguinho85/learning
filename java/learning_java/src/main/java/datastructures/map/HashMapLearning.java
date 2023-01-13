package datastructures.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapLearning {
    public static void test() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        map.put(2, 4);
        map.put(3, 5);
        map.put(8, 4);

        System.out.println(map.put(9, 5));
    }
}
