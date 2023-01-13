package designpatterns.factory;

public abstract class A {
    public abstract void m();

    public void mA() {
        System.out.println("class A");
    }

    public C getCInstance() {
        return new C();
    }
}

class B extends A {
    public static void m2() {
        System.out.println("m2");
    }
    public B(){}

    @Override
    public void m() {
        System.out.println("class B");
    }
}

class C extends A {
    C(){};

    @Override
    public void m() {
        System.out.println("class C");
    }

    public void m2() {
        System.out.println("m2");
    }
}
