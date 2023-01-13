package datastructures;

import java.util.Iterator;
import java.util.Stack;

public class StackLearning {
    public static void test() {
        Stack<String> stack = new Stack<>();
        stack.push("asd");
        stack.push("tres");

        Iterator e = stack.iterator();
        while(e.hasNext()) {
            System.out.println(e.next());
        }

        e = stack.iterator();
        while(e.hasNext()) {
            System.out.println(e.next());
        }
    }
}
