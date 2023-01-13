package generaltopics;

// Class created just to reserve the name of the topic
public class Supertypes {
}


//Supertype method is a method defined in the superclass or declared in an interface
interface I {
    void run();
}
class A implements I {
    public void method() {

    }

    public void run() {

    }
}

class B extends A implements I {
    @Override
    public void method() {

    }

    @Override
    public void run() {

    }
}

class C implements I {
    @Override
    public void run() {

    }
}