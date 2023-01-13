package datastructures.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLearning {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
/*
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
*/
/*
        Integer current = queue.remove();
        System.out.println(current);
        System.out.println(queue);
*/
        queue.poll();
        Integer current = queue.poll();
        System.out.println(current);
        System.out.println(queue);
    }

    public static void test() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        Iterator e = queue.iterator();
        while(e.hasNext()) {
            System.out.println(queue.remove());
        }

        e = queue.iterator();
        while(e.hasNext()) {
            System.out.println(e.next());
        }
    }
}
