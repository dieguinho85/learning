package streams.tomap;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToTreeMap {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.println("--------------");
        collectorsToMap();
        System.out.println("--------------");
        collectorsGroupingBy();
        System.out.println("--------------");
    }

    public static List<String> getList() {
        return Arrays.asList("asd", "asd", "fdg", "d", "abcdefg");
    }

    public static void collectorsToMap() {
        TreeMap<String, Integer> map = getList().stream()
                .collect(Collectors.toMap(
                        Function.identity(), // 1. actual String as KEY
                        String::length,  // 2. String length as their VALUE
                        (key1, key2) -> (int)key1, // 3. duplicate KEY resolver
                        TreeMap::new // 4. implementation-class
                ));

        System.out.println(map);
    }

    public static void collectorsGroupingBy() {
        TreeMap<String, Long> map = getList().stream()
                .collect(Collectors.groupingBy(i -> i, TreeMap::new, Collectors.counting()));

        System.out.println(map);
    }
}
