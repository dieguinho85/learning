package casestudies;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CaseOne {
    private Scanner scanner;

    private CaseOne() {
        this.scanner = new Scanner(System.in);
    }

    public static void test() {
        new CaseOne().run();
    }

    public void run() {
        String s = getString();
        Map<Character, Boolean> characters = new TreeMap<>();
        s.chars().mapToObj(c -> (char) c).forEach(c -> characters.put(c, !characters.containsKey(c)));
        Optional<Character> character = s.chars().mapToObj(c -> (char) c).filter(characters::get).findFirst();
        System.out.printf("The first non repeated character is: %s\n", character.isPresent() ? character.get() : null );
    }

    private String getString() {
        System.out.println("Type a String: ");

        for(;;) {
            try {
                return scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Wrong entry, type a valid String:");
                scanner.nextLine();
            }
        }
    }
}
