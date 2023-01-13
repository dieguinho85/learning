package game;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Loop {
    public static void main(String[] args) {
        sizes();
    }

    private static void sizes() {
        Loop loop;
        int times = 100000;
        double r = (double)IntStream.range(0, times).map(i -> new Loop(100).maxSize()).filter(i -> i <= 100 / 2).count() / times;
        System.out.println(r);
    }
    private LinkedHashMap<Integer, Integer> boxes;
    private LinkedList<Integer> numbers;
    private SecureRandom secureRandom;

    public Loop(int size) {
        this.boxes = new LinkedHashMap<>();
        this.secureRandom = new SecureRandom();
        this.numbers = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toCollection(LinkedList<Integer>::new));
        wrapNumers();
    }

    private void wrapNumers() {
        LinkedList<Integer> tmpNumbers = (LinkedList<Integer>)this.numbers.clone();
        int index;

        while(!tmpNumbers.isEmpty()) {
            index = secureRandom.nextInt(tmpNumbers.size());
            boxes.put(boxes.size() + 1, tmpNumbers.get(index));
            tmpNumbers.remove(index);
        };
    }

    public void printLoops() {
        LinkedList<LinkedList<Integer>> loops = getLoops();
        System.out.println("########### boxes #########");
        boxes.entrySet().stream().forEach(e -> System.out.printf("%d -> %d | ", e.getKey(), e.getValue()));
        System.out.println();
        System.out.println("########### loops #########");
        loops.stream().forEach(loop -> System.out.printf("size: %d | elements: %s\n", loop.size(), loop));
    }

    public int maxSize() {
        return getLoops().stream().map(LinkedList::size).max(Integer::compare).get();
    }

    public LinkedList<LinkedList<Integer>> getLoops() {
        LinkedList<LinkedList<Integer>> loops = new LinkedList<>();
        LinkedList<Integer> loop;
        LinkedList<Integer> tmpNumbers = (LinkedList<Integer>)this.numbers.clone();
        int index;
        int startNumber;
        int current;
        int old;

        while(!tmpNumbers.isEmpty()) {
            loop = new LinkedList<>();
            loops.add(loop);
            index = secureRandom.nextInt(tmpNumbers.size());
            startNumber = tmpNumbers.get(index);
            current = startNumber;

            do {
                old = current;
                loop.add(current);
                current = boxes.get(current);
                tmpNumbers.remove(new Integer(old));
            } while(startNumber != current);
        }

        return loops;
    }
}
