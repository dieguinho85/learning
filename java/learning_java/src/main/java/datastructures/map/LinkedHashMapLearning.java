package datastructures.map;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LinkedHashMapLearning {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(2, 4);
        Map.Entry<Integer, Integer> asd;

        linkedHashMap.put(2, 4);
    }



    public static void test() {
        SecureRandom random = new SecureRandom();
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        LinkedHashMap<Integer, Integer> asd = new LinkedHashMap<Integer, Integer>();
        asd.put(23, 23);

        Long startTime = System.currentTimeMillis();
        System.out.println("Testing HashMap");
        IntStream.range(0, 10000000).forEach(x -> hashMap.put(random.nextInt(), random.nextInt()));
        System.out.printf("HashMap test finished in: %d\n", System.currentTimeMillis() - startTime );

        startTime = System.currentTimeMillis();
        System.out.println("Testing LinkedHashMap");
        IntStream.range(0, 10000000).forEach(x -> linkedHashMap.put(random.nextInt(), random.nextInt()));
        System.out.printf("LinkedHashMap test finished in: %d\n", System.currentTimeMillis() - startTime );
    }
}
