package datastructures.set;

import sun.awt.geom.AreaOp;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class HashSetLearning {
    public static void test() {
        Set<String> list = new HashSet<String>();
        list.add("alsdjlk");
        list.add(null);
        list.add("");
        list.add("asd");
        list.add("zxc");
        list.add("lkj");
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextGaussian());

        System.out.println((int) 'á');
        IntStream.range(150, 300).forEach(i -> System.out.printf("i: %d, c: %s\n", i, (char) i));
    }
}
