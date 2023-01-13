package datastructures.list;

import java.util.LinkedList;

public class LinkedListLearning {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("my string");
        linkedList.add("my second string");
        linkedList.add("my third string");
        linkedList.add(1, "my fourth string");
        linkedList.add(1, "my fourth string");

        linkedList.forEach(System.out::println);
    }
}
