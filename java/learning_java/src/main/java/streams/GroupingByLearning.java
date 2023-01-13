package streams;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupingByLearning {
    public static void main(String[] args) {
        new A().test();
    }
}

class A implements Runnable {
    public void run() {
        IntStream.range(0, 100).boxed().map(n -> {
                    System.out.printf("n: %d | thread_id: %d | thread_name: %s\n",
                            n, Thread.currentThread().getId(), Thread.currentThread().getName());

                    return Thread.currentThread().getId();
                }).collect(Collectors.groupingBy(Long::intValue, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().forEach(System.out::println);
    }
    public void run2() {
        IntStream.range(0, 100).boxed().map(n -> {
                    System.out.printf("n: %d | thread_id: %d | thread_name: %s\n",
                            n, Thread.currentThread().getId(), Thread.currentThread().getName());

                    return Thread.currentThread().getId();
                }).collect(Collectors.groupingBy(Long::intValue, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().forEach(System.out::println);
    }

    public void test() {
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        t1.start();
        t2.start();
    }
}