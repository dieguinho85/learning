package designpatterns;

import designpatterns.factory.A;
import designpatterns.factory.AFactory;

import java.text.NumberFormat;
//import designpatterns.factory.B;

public class Main {
    public static void main(String[] args) {
        A a = AFactory.get();
    }
}
