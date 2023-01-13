package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GenericClasses {
    public static void main(String[] args) {
        A a = new A() {
            @Override
            public boolean m() {
                return false;
            }
        };

        I i = () -> false;
        System.out.println(i.m());
    }

    public static <T> List<T> getList(T t) {
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }
}

abstract class A {
    public abstract boolean m();
}

interface I {
    public boolean m();
}

class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }

    public void method() {
        System.out.println("t" + t + t);
    }
}
