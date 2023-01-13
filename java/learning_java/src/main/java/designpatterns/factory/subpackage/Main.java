package designpatterns.factory.subpackage;

import designpatterns.factory.A;
import designpatterns.factory.AFactory;
//import designpatterns.factory.B;

public class Main {
    public static void main(String[] args) {
        A a = AFactory.get();

        a.m();
    }
}
