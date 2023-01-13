import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public List l = new ArrayList();

    public static void main(String[] args) {

    }
}

class A {
    static void m() {
        System.out.println("Static A");
    }

    void m2() {
        System.out.println("instance A");
    }
}

class B extends A {
    static void m() {
        System.out.println("static B");
    }

    @Override
    void m2() {
        System.out.println("instance B");
    }
}

interface I {
    public static final Integer n = 254;
    static final Integer y = 254;
}

abstract class AC {
    protected Integer n = 254;
}