package designpatterns.factory;

public class AFactory {
    public static A get() {
        B.m2();
        B b = new B();
        B b2;
        return new B();
    }
}
