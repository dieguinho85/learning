package datastructures.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListLearning {
    public static void test() {
        List list = new ArrayList();
        list.add("alsdjlk");
        list.add(null);
        list.add(7);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
