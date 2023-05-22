package _03_operators;

import java.util.Scanner;

public class SwitchOperator {
    public static void main(String[] args) {
        int k = new Scanner(System.in).nextInt();
        switch (k) {
            case 1  -> System.out.println("one");
            case 2  -> System.out.println("two");
            default -> System.out.println("many");
        }
        System.out.println(
                switch (k) {
                    case  1 -> "one";
                    case  2 -> "two";
                    default -> "many";
                }
        );
        String result1 = switch (k) {
            case 1 -> "L1";
            case 2 -> "L2";
            default -> "Other";
        };
        System.out.println("result1: " + result1);
        String result2 = switch(k) {
            case 1:
                yield "One";
            case 2:
                yield "Two";
            default:
                yield "Other";
        };
        System.out.println("result2: " + result2);
    }
}
