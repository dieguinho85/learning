package multithreading;

import java.util.Arrays;
import java.util.stream.IntStream;

abstract class Task extends Thread {
    public static synchronized int index() {
        Integer index = Integer.parseInt(Solution.i);
        Solution.i = (index + 1) + "";

        return index;
    }
}
class Task1 extends Task {
    static int a;
    static int beg;

    public void run() {
        for(int i = 0; i < a; i++) {
            Solution.threadArray[index()] = i;
        }
    }
}

class Task2 extends Task {
    static int a;
    static int beg;
    static boolean active = true;

    public void run() {
        for(int i = beg; i < a + beg; i++) {
            Solution.threadArray[index()] = i;
        }
    }
}

class Task3 extends Task {
    static int a;
    static int beg;

    public void run() {
        for(int i = beg; i < a + beg; i++) {
            Solution.threadArray[i] = i;
        }
    }
}

//This is the test method, you shouldn't modify it
public class Solution {
    public static final int[] threadArray = new int[300];
    public static volatile String i = 0+"";
    public boolean test() throws InterruptedException
    {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Thread task2Thread = new Thread(task2);
        Thread task3Thread = new Thread(task3);
        task1.start();
        task2Thread.start();
        task1.join();
        task2Thread.join();
        task3Thread.start();
        int first = Task1.a+Task2.a;
        int containsSecondThread = Task1.a;
        String oneAndTwo = "";
        String sizeOfTask1 = "";
        for(int i=0;i<first;i++)
        {
            oneAndTwo += threadArray[i]+" ";
        }
        for(int i=0;i<containsSecondThread;i++)
        {
            sizeOfTask1 += threadArray[i]+" ";
        }
        int begOfTask3 = Task3.beg;
        String checkingString = "";
        for(int i=begOfTask3;i<threadArray.length;i++)
        {
            checkingString += i + " ";
        }
        String task3String = "";
        for(int j = begOfTask3;j<threadArray.length;j++)
        {
            task3String += threadArray[j]+" ";
        }

        if((!oneAndTwo.contains(begOfTask3+"") && sizeOfTask1.contains(Task2.beg+"")) && task3String.equals(checkingString))
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws InterruptedException
    {
        // 80, 0 | 90, 80 | 130, 170
        Solution solution = new Solution();
        int one = 80;
        Task1.a = one;
        Task1.beg = 0;
        int two = 90;
        Task2.a = two;
        Task2.beg = one;
        int three = 130;
        Task3.a = three;
        Task3.beg = one+two;
        boolean result = solution.test();
        System.out.println("############Result########################");
        System.out.println(result);
        System.out.println();

        // I created this method to check for data when result is false
        if(result) {
            Logger.debug(result);
        }
    }
}

// class created to show some information
class Logger {
    public static void debug(boolean result) throws InterruptedException {

        System.out.println("############Entry Values########################");
        System.out.printf("%d, %d | %d, %d | %d, %d  \n", Task1.a, Task1.beg,
                Task2.a, Task2.beg, Task3.a, Task3.beg);

        if(result) {
            System.out.println("SUCCESS");
        }

        System.out.println();

        System.out.println("##############Null indexes######################");
        IntStream.range(0, Solution.threadArray.length).filter(i -> i > 0 && Solution.threadArray[i] == 0).forEach(System.out::println);

        System.out.println("##############All Values in Solution.threadArray######################");
        IntStream.range(0, 10).forEach(i -> {
            IntStream.range(i * 30, i * 30 + 30).forEach(e -> System.out.printf("%5s", Solution.threadArray[e]));
            System.out.println();
        });

        System.out.println("##############Sorted Values######################");
        Arrays.sort(Solution.threadArray);
        IntStream.range(0, 10).forEach(i -> {
            IntStream.range(i * 30, i * 30 + 30).forEach(e -> System.out.printf("%5s", Solution.threadArray[e]));
            System.out.println();
        });
    }
}